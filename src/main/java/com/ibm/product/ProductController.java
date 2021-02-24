package com.ibm.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable String id) {
        productService.updateProduct(id, product);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
    public void deleteProduct(@PathVariable Product id) {
        productService.deleteProduct(id);
    }

}
