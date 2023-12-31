package com.food.need.controller;

import com.food.need.models.FoodMenu;
import com.food.need.models.FoodOrder;
import com.food.need.service.FoodMenuService;
import com.food.need.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private FoodMenuService foodMenuService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/fooditem")
    public List<FoodMenu> getAllFoodItems() {
        return foodMenuService.getAllFoodItems();
    }

    @GetMapping("/fooditem/{id}")
    public FoodMenu getFoodItemById(@PathVariable Long id) {
        return foodMenuService.getFoodItemById(id);
    }

    @PostMapping("/fooditem")
    public ResponseEntity<String> createFoodItem(@RequestBody FoodMenu foodItem) {
        HttpStatus status;
        String msg = "";
        if(foodMenuService.addFoodItem(foodItem)){
            msg ="Food item added";
            status = HttpStatus.ACCEPTED;
        }else{
            msg ="Information is Not Valid";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg,status);
    }

    @DeleteMapping("/fooditem/{id}")
    public void deleteFoodItem(@PathVariable Long id) {
        foodMenuService.deleteFoodItem(id);
    }

    @GetMapping("/orders")
    public List<FoodOrder> getAllOrders(){
        return orderService.getAllOrders();
    }
}
