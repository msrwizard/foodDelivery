package com.food.need.repository;

import com.food.need.models.Admin;
import com.food.need.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
    User findByUserId(Long userId);

    User findFirstByUserEmail(String userEmail);
}
