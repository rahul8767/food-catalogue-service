package com.coderahul.foodcatalogue.dto;

import java.util.List;

import com.coderahul.foodcatalogue.entity.FoodItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCatlaoguePage {

	private List<FoodItem>  foodItemList;
	private Restaurant 	restaurant;
	public List<FoodItem> getFoodItemList() {
		return foodItemList;
	}
	public void setFoodItemList(List<FoodItem> foodItemList) {
		this.foodItemList = foodItemList;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}
