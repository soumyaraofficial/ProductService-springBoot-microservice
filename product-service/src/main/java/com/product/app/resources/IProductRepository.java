package com.product.app.resources;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.app.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p ORDER BY p.price ASC")
	public List<Product> sortAllProductByPrice();

	@Query("select p from Product p where p.category = ?1")
	public List<Product> getProductByCategory(String category);

	@Query("select p from Product p where p.price between ?1 and ?2")
	public List<Product> getProductByRange(int minPrice, int maxPrice);

	@Query("SELECT p FROM Product p WHERE p.category = ?1 ORDER BY p.price ASC")
	public List<Product> sortProductsOfSameCategoryByPrice(String category);



}
