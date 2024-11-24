package com.product.app.service;

import java.util.List;

import com.product.app.entity.Product;

public interface IProductService {
	
public String addProduct(Product product);
public String addAllProduct(List<Product> product);
public List<Product> getAllProduct();
public Product getProductById(int id);
public  List<Product> getProductByCategory(String category);
public List<Product> getProductByRange(int min , int max);
public String compareTwoProductByPriceAndCategory(int id1,int id2);
public List<Product> sortAllProductByPrice();
public List<Product> sortProductOfSameCategoryByPrice(String category);
public String deleteProduct(int id);

public String updateProduct(Product product);
public String updateProductPrice(int id,double price);


}
