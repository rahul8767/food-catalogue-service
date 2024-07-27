package com.coderahul.foodcatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderahul.foodcatalogue.dto.FoodCatlaoguePage;
import com.coderahul.foodcatalogue.dto.FoodItemDto;
import com.coderahul.foodcatalogue.entity.FoodItem;
import com.coderahul.foodcatalogue.service.FoodCatalogueService;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {
	
	@Autowired
	FoodCatalogueService foodCatalogueService;
	
	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItemDto){
		
		FoodItemDto foodItemSaved = foodCatalogueService.addFoodItem(foodItemDto);
		
		return new ResponseEntity<>(foodItemSaved,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/fetchRestaurantAndFoodItemById/{restaurantId}")
	public ResponseEntity<FoodCatlaoguePage> fetchRestauDetailsWithFoodMenu(@PathVariable Integer restaurantId){
		
		FoodCatlaoguePage foodCatlaoguePage = foodCatalogueService.fetchFoodCataloguePageDetails(restaurantId);
		
		return new ResponseEntity<>(foodCatlaoguePage,HttpStatus.OK);
	}
	
	

}
