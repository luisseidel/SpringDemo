package com.seidelsoft.SpringDemo.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotEmpty(message = "Please enter a valid name")
    private String name;

    @NotEmpty(message = "Please enter a valid email")
    private String email;

    @NotEmpty(message = "Please enter a valid password")
    private String password;

}
