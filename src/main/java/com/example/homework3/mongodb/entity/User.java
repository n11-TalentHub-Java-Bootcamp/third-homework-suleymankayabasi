package com.example.homework3.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "user")
public class User {

    @Id
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
