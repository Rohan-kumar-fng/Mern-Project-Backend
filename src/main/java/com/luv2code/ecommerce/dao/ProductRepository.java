package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

    // This will write query internally like (select * from products where category_id = id);
    // The exposed endpoints are
    // http://localhost:8080/api/products/search/findByCategoryId?id=1
    // same as function name

    // You can also write it in @Query field.(TODO: implement using @Query)
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);


    // Here It is automatically create the query as Select * from Product p where p.name like concat('%',"name,'%')
    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);

    // checking for name
    // Here you have to put the whole name
    Page<Product> findByName(@Param("name") String name, Pageable pageable);
}
