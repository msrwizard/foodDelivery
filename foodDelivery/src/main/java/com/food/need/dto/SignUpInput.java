package com.food.need.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpInput {
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private String userContactNumber;
}
