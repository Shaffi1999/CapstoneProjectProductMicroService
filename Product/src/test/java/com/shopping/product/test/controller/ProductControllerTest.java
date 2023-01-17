package com.shopping.product.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.shopping.product.controller.ProductController;
import com.shopping.product.entity.Product;
import com.shopping.product.service.ProductService;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ProductService productService;

	@Test
	void testGetAll() throws Exception {
		Product product1 = new Product(1, "Bat", 5000, 20);
		Product product2 = new Product(2, "Ball", 50, 10);
		Product product3 = new Product(3, "Tennis Bat", 500, 20);

		List<Product> list = new ArrayList<Product>();

		list.add(product1);
		list.add(product2);
		list.add(product3);

		Mockito.when(productService.getAllProducts()).thenReturn(list);

		mvc.perform(get("/product/getAll").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());
	}

}
