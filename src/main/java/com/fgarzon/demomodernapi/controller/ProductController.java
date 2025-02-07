package com.fgarzon.demomodernapi.controller;

import com.fgarzon.demomodernapi.entity.Product;
import com.fgarzon.demomodernapi.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/{category}")
    public ResponseEntity<CollectionModel<Product>> getProductsByCategory(@PathVariable String category,
                          @RequestHeader(value = "If-None-Match", required = false) String eTag) {
        System.out.println("eTag: " + eTag);
        List<Product> findedList = productService.getProductsByCategory(category);
        String currentTag = generateETag(findedList);
        System.out.println("currentTag: " + currentTag);
        if (currentTag.equals(eTag)) {
            System.out.println("Sin modificaciones en la respuesta");
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }

        Link link = linkTo(methodOn(ProductController.class).getProductsByCategory(category, eTag))
                .withRel("productsByCategory");

        CollectionModel<Product> result = CollectionModel.of(findedList, link);

        return ResponseEntity.ok().eTag(currentTag).body(result);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<EntityModel<Product>> getProductById(@PathVariable String id,
                                                               @RequestHeader(value = "If-None-Match", required = false) String eTag) {
        Product findedProduct = productService.getProductById(Long.valueOf(id));
        String currentTag = generateETag(findedProduct);
        if (currentTag.equals(eTag)) {
            System.out.println("Sin modificaciones en la respuesta");
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        Link link = linkTo(methodOn(ProductController.class).getProductById(id, eTag))
                .withRel("productsById");

        EntityModel<Product> result = EntityModel.of(findedProduct, link);

        return ResponseEntity.ok().eTag(currentTag).body(result);
    }

    private String generateETag(Object findedList) {
        return Integer.toHexString(findedList.hashCode());
    }

}
