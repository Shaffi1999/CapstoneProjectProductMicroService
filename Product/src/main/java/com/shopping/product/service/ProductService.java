package com.shopping.product.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.product.controller.ProductController;
import com.shopping.product.entity.Product;
import com.shopping.product.entity.ProductForCustomer;
import com.shopping.product.exception.ProductNotFoundException;
import com.shopping.product.repository.ProductRepository;

@Service
public class ProductService implements IProductService{
	Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository repository;
	@Override
	public Product addProduct(Product product) {
		logger.info("Entered Add Product  Service");
	
		return repository.save(product);
	}
	@Override
	public List<Product> getAllProducts() {
		logger.info("Entered get all product Service");
		return repository.findAll();
	}
	@Override
	public Product getProductById(int id) {
		logger.info("Entered get By ID  Service");
		return repository.findById(id).orElseThrow(
				()->new ProductNotFoundException("Product With Id: "+id+" Is Not Found")
				);
	}
	@Override
	public boolean deletById(int id) {
		logger.info("Entered delete By ID  Service");
		Product product=repository.findById(id).orElseThrow(()->new ProductNotFoundException("Product With Id: "+id+" Is Not Found"));
		if(product!=null)
		{
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	@Override
	public Product updateProduct(Product product, int id) {
		logger.info("Entered Update Product by ID  Service");
		Product p=repository.findById(id).orElseThrow(()->new ProductNotFoundException("Product With Id: "+id+" Is Not Found"));
	    p.setId(product.getId());
	    p.setProductName(product.getProductName());
	    p.setStockCount(product.getStockCount());
	    p.setPrice(product.getPrice());
	    	    
	    return repository.save(p);
	}
	@Override
	public List<Product> searchByName(String keyword) {
		System.out.println(keyword);
		return repository.findByName(keyword);
	}
//	@Override
//	public List<ProductForCustomer> productsForCustomer() {
//		// TODO Auto-generated method stub
//		return repository.findAllProductsForCustomer();
//	}
	@Override
	public int checkStockCount(int id) {
		Product product=repository.findById(id).get();
		return product.getStockCount();
	}
	@Override
	public void updateStockCount(int quantity, int pid) {
		repository.updateQuantity(quantity, pid);
		
	}
	@Override
	public void updateStockCountOnDelete(int quantity, int pid) {
		repository.updateQuantityIncrement(quantity, pid);
		
	}
	
	
	
	
	
	
	

}
