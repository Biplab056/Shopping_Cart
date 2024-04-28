package com.jsp.ShoppingCart.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.jsp.ShoppingCart.DTO.Product;
import com.jsp.ShoppingCart.REPOSITORY.ProductRepository;

@Repository
public class ProductDao {
	
	@Autowired
	ProductRepository repository;
	
	
	// ADD PRODUCT
	public String addproduct(Product product) {
		repository.save(product);
		return "product added to cart succesfully";
	}
	// GET ALL PRODUCT
	public List<Product> getAllproduct(){
		
		return repository.findAll();
	}
	// FING PRODUCT BY ID
	
	public Product findProductById(int id) {
		Optional<Product> opt = repository.findById(id);
		
		if(opt.isPresent()) {
			
			return opt.get();
		}
		return null;
	}
	
	// DELETE PRODUCT BY ID
	
	public String deleteById(int id) {
		Product p = findProductById(id);
		
		if(p != null) {
			String product = p.getProduct_name();
			repository.delete(p);
			return product+"product is deleted";
		}
		
		return "this product is not available in cart..";
	}
	
	// UPDATE PRODUCT BY ID
	
	public Product updateById(int id, int newquantity) {
		Product p = findProductById(id);

		if(p != null) {
			
			p.setQuantity(newquantity);
			repository.save(p);
			
			return p ;
		}
		
		return null;
	}
	
}
