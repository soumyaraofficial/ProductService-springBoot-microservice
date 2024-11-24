package com.product.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.app.entity.Product;
import com.product.app.resources.IProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceIMPL implements IProductService {

	@Autowired
	private IProductRepository productRepository;

	@Override
	public String addProduct(Product product) {
        productRepository.save(product);
		return "success";
	}

	@Override
	public List<Product> getAllProduct() {	
		return productRepository.findAll();
	}

	@Transactional
	@Override
	public Product getProductById(int id) {
	
		return productRepository.findById(id).get();
	}

	@Override
	public  List<Product> getProductByCategory(String category) {	
		return productRepository.getProductByCategory(category);
	}

	@Override
	public List<Product> getProductByRange(int min, int max) {
	
		return productRepository.getProductByRange(min, max);
	}

	@Override
	public String compareTwoProductByPriceAndCategory(int id1, int id2) {
	    Product p1 = productRepository.findById(id1).orElse(null);
	    Product p2 = productRepository.findById(id2).orElse(null);

	    if (p1 == null || p2 == null) {
	        return "One or both products not found.";
	    }

	    double price1 = p1.getPrice();
	    double price2 = p2.getPrice();

	    String pname1 = p1.getProductName();
	    String pname2 = p2.getProductName();

	    String category1 = p1.getCategory();
	    String category2 = p2.getCategory();

	    String ans;

	    if (price1 > price2) {
	        ans = "Product '" + pname1 + "' is more expensive than Product '" + pname2 + "'. ";
	    } else if (price1 < price2) {
	        ans = "Product '" + pname2 + "' is more expensive than Product '" + pname1 + "'. ";
	    } else {
	        ans = "Both products, '" + pname1 + "' and '" + pname2 + "', have the same price. ";
	    }

	    if (category1.equalsIgnoreCase(category2)) {
	        ans += "Both products belong to the same category: '" + category1 + "'.";
	    } else {
	        ans += "The products belong to different categories: '" +pname1+":-"+ category1 + "' and '" +pname2+":-"+ category2 + "'.";
	    }

	    return ans;
	}


	@Override
	public List<Product> sortAllProductByPrice() {
		return productRepository.sortAllProductByPrice();
	}

	@Override
	public List<Product> sortProductOfSameCategoryByPrice(String category) {
		
		return productRepository.sortProductsOfSameCategoryByPrice(category);
	}

	@Override
	public String addAllProduct(List<Product> product) {
		
		productRepository.saveAll(product);
		return "success";
	}

	@Override
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "success";
	}
	@Override
	public String updateProduct(Product product) {
	    Optional<Product> optionalProduct = productRepository.findById(product.getId());
	    if (optionalProduct.isPresent()) {
	        Product existingProduct = optionalProduct.get();

	        // Update the product fields
	        existingProduct.setProductName(product.getProductName());
	        existingProduct.setPrice(product.getPrice());
	        existingProduct.setCategory(product.getCategory());

	        productRepository.save(existingProduct);
	        return "Product updated successfully";
	    } else {
	        return "Product with ID " + product.getId() + " not found";
	    }
	}

	@Override
	public String updateProductPrice(int id, double price) {
	    Optional<Product> optionalProduct = productRepository.findById(id);
	    if (optionalProduct.isPresent()) {
	        Product existingProduct = optionalProduct.get();

	      
	        existingProduct.setPrice(price);

	        productRepository.save(existingProduct);
	        return "Product price updated successfully";
	    } else {
	        return "Product with ID " + id + " not found";
	    }
	}

}
