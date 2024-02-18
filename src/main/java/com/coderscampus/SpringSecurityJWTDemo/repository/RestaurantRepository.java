package com.coderscampus.SpringSecurityJWTDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coderscampus.SpringSecurityJWTDemo.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

//	List<Restaurant> findByNameContainingIgnoreCase(String keyword); 

	@Query("SELECT r FROM Restaurant r WHERE LOWER(r.name) LIKE %:keyword%")
	List<Restaurant> findRestaurantsUsingKeyword(String keyword);
}
