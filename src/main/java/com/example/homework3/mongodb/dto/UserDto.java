package com.example.homework3.mongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String id;
    @Size(max = 50,message = "Character Size Limit Exceeded.")
    private String name;
    @Size(max = 50,message = "Character Size Limit Exceeded.")
    private String lastName;
    @Size(max = 50,message = "Character Size Limit Exceeded.")
    private String email;
    @Size(max = 15,message = "NUmber Size Limit Exceeded.")
    private String phoneNumber;
    @Size(max = 20,message = "Character Size Limit Exceeded.")
    private String userName;

}
