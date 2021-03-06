package com.produtos.apirest.resources;

import com.produtos.apirest.models.Product;
import com.produtos.apirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Products")
@CrossOrigin(origins = "*")
public class ProductResource {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    @ApiOperation(value = "Returns a list of products")
    public List<Product> listProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    @ApiOperation(value = "Returns an product")
    public Optional<Product> Product(@PathVariable(value = "id") long id) {
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    @ApiOperation(value = "Creates a new product")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/product/{id}")
    @ApiOperation(value = "Deletes a product")
    public void deleteProductById(@PathVariable(value = "id") long id) {
        Product product = productRepository.getOne(id);
        productRepository.delete(product);
    }

    @PutMapping("/product")
    @ApiOperation(value = "Updates a product")
    public Product updateProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

}
