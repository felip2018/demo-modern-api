package com.fgarzon.demomodernapi.controller;

import com.fgarzon.demomodernapi.entity.Product;
import com.fgarzon.demomodernapi.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category,
                          @RequestHeader(value = "If-None-Match", required = false) String eTag) {
        System.out.println("eTag: " + eTag);
        List<Product> findedList = productService.getProductsByCategory(category);
        String currentTag = generateETag(findedList);
        System.out.println("currentTag: " + currentTag);
        if (currentTag.equals(eTag)) {
            System.out.println("Sin modificaciones en la respuesta");
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }

        return ResponseEntity.ok().eTag(currentTag).body(findedList);
    }

    private String generateETag(List<Product> findedList) {
        return Integer.toHexString(findedList.hashCode());
    }

}
