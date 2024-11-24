package com.product.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.app.entity.Product;
import com.product.app.service.IProductService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private IProductService productService;

	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return "success";
	}

	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}

	@GetMapping("/getProductById")
	public Product getProductById(@RequestParam("id") Integer id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/getProductByCategory")
	public List<Product> getProductByCategory(@RequestParam("category")String category){
		return productService.getProductByCategory(category);
	}
	
	@GetMapping("/getProductByRange")
	public List<Product> getProductByRange(@RequestParam("min")Integer min,@RequestParam("max") Integer max)
	{
		return productService.getProductByRange(min, max);
	}
	
	@GetMapping("/getAllProductByPrice")
	public List<Product> sortAllProductByPrice() {
		return productService.sortAllProductByPrice();
	}
	
	@GetMapping("/getProductByCategorySorted")
	public List<Product> sortProductOfSameCategoryByPrice(String category){
		return productService.sortProductOfSameCategoryByPrice(category);
	}
	
	@GetMapping("/compareTwoProduct")
	public String compareTwoProduct(@RequestParam("id1") Integer id1,@RequestParam("id2") Integer id2) {
		return productService.compareTwoProductByPriceAndCategory(id1, id2);
	}
	
	@PostMapping("/addAllProduct")
	public String addAllProduct(@RequestBody List<Product> product) {
		productService.addAllProduct(product);
		return "success";
	}
	
	@PostMapping("/deleteById")
	public String deleteProduct(@RequestParam("id")Integer id) {
		productService.deleteProduct(id);
		return "success";
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@PostMapping("/updateProductPrice")
	public String updateProductPrice(@RequestParam("id")Integer id, @RequestParam("price")Double price) {
		return productService.updateProductPrice(id,price);
	}
	

}
