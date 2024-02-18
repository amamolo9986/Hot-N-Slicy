package com.coderscampus.SpringSecurityJWTDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coderscampus.SpringSecurityJWTDemo.domain.Restaurant;
import com.coderscampus.SpringSecurityJWTDemo.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	private RestaurantRepository restaurantRepo;

	public RestaurantService(RestaurantRepository restaurantRepo) {
		super();
		this.restaurantRepo = restaurantRepo;
	}


	public Restaurant findById(Integer restaurantId) {
		Optional<Restaurant> restaurantOpt = restaurantRepo.findById(restaurantId);
		return restaurantOpt.orElse(null);
	}
	
	public List<Restaurant> findByName(String keyword) {
		System.out.println(keyword);
		return restaurantRepo.findRestaurantsUsingKeyword(keyword);
	}


	public List<Restaurant> getAllRestaurants() {
		return restaurantRepo.findAll();
	}
	
}
