package com.shopping.product.service;

import java.util.List;

import com.shopping.product.entity.Product;
import com.shopping.product.entity.ProductForCustomer;

public interface IProductService {
public Product addProduct(Product product);
public List<Product> getAllProducts();
public Product getProductById(int id);
public boolean deletById(int id);
public Product updateProduct(Product product,int id);
public List<Product> searchByName(String keyword);
//public List<ProductForCustomer> productsForCustomer();
public int  checkStockCount(int id);
public void updateStockCount(int quantity,int pid);
public void updateStockCountOnDelete(int quantity,int pid);

}
