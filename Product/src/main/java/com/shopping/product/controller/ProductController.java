package com.shopping.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.product.entity.Product;
import com.shopping.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService service;
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product)
	{
		logger.info("Entered Into Add Product Rest Api");
		return service.addProduct(product);
	}
	
	@GetMapping("/getAll")
	public List<Product> getAll()
	{
		logger.info("Entered Into Get All Product Rest Api");
		return service.getAllProducts();
	}
	
	@GetMapping("/get/{id}")
	public Product getProductById(@PathVariable("id") int id)
	{
		logger.info("Entered Into Get Product By Id Rest Api");
		return service.getProductById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deletById(@PathVariable("id") int id)
	{
		logger.info("Entered Into Delete By Id Rest Api");
		return service.deletById(id);
	}
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@RequestBody Product product,@PathVariable("id") int id)
	{
		logger.info("Enterd Into update by id rest api");
		return service.updateProduct(product,id);
	}
	
	@GetMapping("/search/{key}")
	public List<Product> searchByName(@PathVariable("key") String key)
	{
		System.out.println(key);
		return service.searchByName(key);
	}
	
//	@GetMapping("/getAllForCustomers")
//	public List<ProductForCustomer> productsForCustomers()
//	{
//		return service.productsForCustomer();
//	}
	
	@GetMapping("/stockcount/{id}")
	public int getStockCount(@PathVariable("id") int id)
	{
		return service.checkStockCount(id);
	}
	
	
	@GetMapping("/updatestock/{quantity}/{pid}")
	public void updateStock(@PathVariable("quantity") int quantity,@PathVariable("pid") int pid)
	{
		service.updateStockCount(quantity, pid);
	}
	
	
	@GetMapping("/updatestockdelete/{quantity}/{pid}")
	public void updateStockOnDelete(@PathVariable("quantity") int quantity,@PathVariable("pid") int pid)
	{
		service.updateStockCountOnDelete(quantity,pid);
	}
	


	
	

}
