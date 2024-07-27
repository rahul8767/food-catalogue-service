package com.coderahul.foodcatalogue.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.coderahul.foodcatalogue.dto.FoodItemDto;
import com.coderahul.foodcatalogue.entity.FoodItem;

@Mapper
public interface FoodItemMapper {

	FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class); 
	
	FoodItem mapFoodItemDtoToFoodItem(FoodItemDto foodItemDTO);
	
	FoodItemDto mapFoodItemToFoodItemDto(FoodItem foodItem);
	
}
