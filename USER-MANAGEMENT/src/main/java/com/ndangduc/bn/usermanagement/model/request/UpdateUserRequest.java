package com.ndangduc.bn.usermanagement.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    @NotNull(message = "User Name is required")
    @NotEmpty(message = "User name is not empty")
    @ApiModelProperty(
            example = "Duc Terry",
            notes = "User name cannot be empty",
            required = true
    )
    private String userName;


    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is not empty")
    @ApiModelProperty(
            example = "abc13579",
            notes = "Password cannot be empty",
            required = true
    )
    private String password;

    @NotNull(message = "Address is required")
    @NotEmpty(message = "Address is required")
    @ApiModelProperty(
            example = "Long Bien - Ha Noi",
            notes = "Address cannot be empty",
            required = true
    )
    private String address;

    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "Email must correct format")
    @ApiModelProperty(
            example = "ducnd@ttc-solutions.com.vn",
            notes = "Email cannot be empty",
            required = true
    )
    private String email;

    @Pattern(regexp = "(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Phone Number must corect format")
    @ApiModelProperty(
            example = "0919992222",
            notes = "Phone cannot be empty",
            required = true
    )
    private String phone;
}
