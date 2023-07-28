package com.food.need.repository;

import com.food.need.models.Admin;
import com.food.need.models.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends JpaRepository<FoodOrder, Long> {
    FoodOrder findByFoodOrderId(Long orderId);
}
