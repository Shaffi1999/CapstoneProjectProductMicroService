package com.shopping.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query(value = "select * from finalproduct.product p where p.name like %?1% ", nativeQuery = true)
	public List<Product> findByName(@Param("keyword") String keyword);

	@Transactional
	@Modifying
	@Query("update Product  set stockCount = (stockCount-:quantity) where id = :id")
	void updateQuantity(@Param("quantity") Integer quantity, @Param("id") Integer id);

	@Transactional
	@Modifying
	@Query("update Product  set stockCount = (stockCount+:quantity) where id = :id")
	void updateQuantityIncrement(@Param("quantity") Integer quantity, @Param("id") Integer id);

//	@Query(value="select id,product_name,price from product",nativeQuery = true)
//	public List<ProductForCustomer> findAllProductsForCustomer();

}
