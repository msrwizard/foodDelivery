package com.food.need.repository;

import com.food.need.models.Admin;
import com.food.need.models.FoodMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodMenuRepo extends JpaRepository<FoodMenu, Long> {
    FoodMenu findByFoodItemId(Long foodItemId);
}
