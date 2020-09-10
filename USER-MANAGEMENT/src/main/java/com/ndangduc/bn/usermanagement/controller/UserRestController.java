package com.ndangduc.bn.usermanagement.controller;

import com.ndangduc.bn.usermanagement.model.request.CreateUserRequest;
import com.ndangduc.bn.usermanagement.model.response.UserDTO;
import com.ndangduc.bn.usermanagement.service.IUserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/user/v1.0/users")
@Api(tags = "User Management", description = "CRUD User")
public class UserRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    IUserService userService;

    @ApiOperation(value = "Get list user", response = UserDTO.class)
    @ApiResponses({
            @ApiResponse(code=500,message = "Error System")
    })
    @PostMapping("")
    public ResponseEntity<?> createUser(@Valid
                                        @RequestBody
                                        @ApiParam(value = "Create New User") CreateUserRequest createUserRequest) {
        LOGGER.info("[Create User]   --- :  START");
        UserDTO userDTO = userService.createUser(createUserRequest);
        LOGGER.info("[Create User]   --- : END");
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }


}
