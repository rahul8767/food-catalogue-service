package com.coderahul.foodcatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coderahul.foodcatalogue.dto.FoodCatlaoguePage;
import com.coderahul.foodcatalogue.dto.FoodItemDto;
import com.coderahul.foodcatalogue.dto.Restaurant;
import com.coderahul.foodcatalogue.entity.FoodItem;
import com.coderahul.foodcatalogue.mapper.FoodItemMapper;
import com.coderahul.foodcatalogue.repo.FoodItemRepo;

@Service
public class FoodCatalogueService {

	@Autowired
	FoodItemRepo foodItemRepo;
	
	@Autowired
	RestTemplate restTemplate;

	public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
		// TODO Auto-generated method stub
		
		
		FoodItem foodItemsavedInDB=foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemDto));
		
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItemsavedInDB);
	}

	public FoodCatlaoguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
		// TODO Auto-generated method stub
		
		List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
		Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
		return createFoodCataloguePage(foodItemList,restaurant);
		
		}

	private FoodCatlaoguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
		// TODO Auto-generated method stub
		FoodCatlaoguePage catlaoguePage = new FoodCatlaoguePage();
		catlaoguePage.setFoodItemList(foodItemList);
		catlaoguePage.setRestaurant(restaurant);
		
		return catlaoguePage;
		//FoodItem
		
	}

	private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId, Restaurant.class);
		
	}

	private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
		// TODO Auto-generated method stub
		
		return foodItemRepo.findByRestaurantId(restaurantId);
		
	}
	
	
}
