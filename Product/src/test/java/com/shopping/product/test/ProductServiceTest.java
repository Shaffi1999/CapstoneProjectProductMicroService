package com.shopping.product.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.shopping.product.entity.Product;
import com.shopping.product.repository.ProductRepository;
import com.shopping.product.service.ProductService;
@ExtendWith(value= {MockitoExtension.class})
class ProductServiceTest {
	@Mock
	private ProductRepository repository;


	@InjectMocks
	private ProductService service;
	@Test
void testAddProduct() {
		 Product product=new Product(1,"Bat",300,4);
	     when(repository.save(product)).thenReturn(product);
	     assertEquals(product,service.addProduct(product));
		
}
	
	List<Product> productList=new ArrayList<Product>();
	

	@Test
	void testGetAll() {
		productList.add(new Product(1,"Bat",400,30));
		productList.add(new Product(2,"Ball",500,20));


		when(repository.findAll()).thenReturn(productList);

		assertEquals(2,service.getAllProducts().size());
		
			}

	@Test
	void testGetProductById() {
		Product p1=new Product(3,"Bat",400,300);
		Optional<Product> optionalProduct=Optional.of(p1);
		
		Mockito.when(repository.findById(1)).thenReturn(optionalProduct);
		  Product actuals=service.getProductById(1);
		  assertEquals(p1.getId(), actuals.getId());
	}
	
	
//
	@Test
	void testDeletById() {
		Product product=new Product(1,"Bat",800,20);
Optional<Product> optionalProduct=Optional.of(product);
		
		Mockito.when(repository.findById(1)).thenReturn(optionalProduct);

		service.deletById(1);
		
		verify(repository,times(1)).deleteById(1);
	}
//
	@Test
		public void test_updateStudent()
		{
		
		
		 Product product=new Product(1,"Bat",300,4);
	     when(repository.save(product)).thenReturn(product);
	     assertEquals(product,service.addProduct(product));
			
		}
		
		
		
	}


