package com.jsp.ShoppingCart.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ShoppingCart.DAO.ProductDao;
import com.jsp.ShoppingCart.DTO.Product;

@RestController
public class ProductController {
	
	   @Autowired
		ProductDao dao;
	   
	   @PostMapping("/product")
	   public String saveProduct(@RequestBody  Product product) {
		   
		   return dao.addproduct(product);
	   }
		
	   @GetMapping("/product")
	   public List<Product> findAllproduct(){
		   return dao.getAllproduct();
	   }
	   
	   @GetMapping("/getproduct")
	   public Product getProductById(@RequestParam int id) {
		   return dao.findProductById(id);
	   }
	   	
	   @DeleteMapping("/delete")
	   public String deleteById(@RequestParam int id) {
		  return dao.deleteById(id);
	   }
	   
	   @PutMapping("/update")
	   public Product updateById(@RequestParam int id,@RequestParam int newquantity) {
		   return dao.updateById(id, newquantity);
	   }
}
