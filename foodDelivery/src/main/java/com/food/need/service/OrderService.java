package com.food.need.service;

import com.food.need.models.FoodMenu;
import com.food.need.models.FoodOrder;
import com.food.need.models.User;
import com.food.need.repository.IFoodMenuRepo;
import com.food.need.repository.IOrderRepo;
import com.food.need.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    IOrderRepo iFoodOrderRepository;

    @Autowired
    IUserRepo iUserRepository;

    @Autowired
    IFoodMenuRepo foodItemRepository;

    public FoodOrder createOrder(FoodOrder foodOrder) {

        User user = iUserRepository.findByUserId(foodOrder.getUser().getUserId());
        foodOrder.setUser(user);
        FoodMenu foodItem = foodItemRepository.findByFoodItemId(foodOrder.getFoodItem().getFoodItemId());
        foodOrder.setFoodItem(foodItem);

        return iFoodOrderRepository.save(foodOrder);
    }

    public FoodOrder getOrderById(Long orderId) {
        return iFoodOrderRepository.findByFoodOrderId(orderId);
    }

    public List<FoodOrder> getAllOrders() {
        return iFoodOrderRepository.findAll();
    }
}
