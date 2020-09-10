package com.ndangduc.bn.usermanagement.controller;

import com.ndangduc.bn.usermanagement.model.request.CreateUserRequest;
import com.ndangduc.bn.usermanagement.model.request.UpdateUserRequest;
import com.ndangduc.bn.usermanagement.model.response.UserDTO;
import com.ndangduc.bn.usermanagement.service.IUserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/user/v1.0/users")
@Api(tags = "User Management", description = "CRUD User")
public class UserRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    IUserService userService;

    @ApiOperation(value = "Create New User", response = UserDTO.class)
    @ApiResponses({
            @ApiResponse(code = 500, message = "Error System")
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


    @ApiOperation(value = "Get All User", response = UserDTO.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 500, message = "Error System")
    })
    @GetMapping("")
    public ResponseEntity<?> getListUser() {
        LOGGER.info("[Get All User]   --- :  START");
        List<UserDTO> userDTOs = userService.getAllUser();
        LOGGER.info("[Get All User]   --- : END");
        return ResponseEntity.status(HttpStatus.OK).body(userDTOs);
    }


    @ApiOperation(value = "Find User By ID", response = UserDTO.class)
    @ApiResponses({
            @ApiResponse(code = 500, message = "Error System")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> findUserByID(@PathVariable
                                          @ApiParam(value = "Find User By ID", defaultValue = "1") Long id) {
        LOGGER.info("[Find User By ID]   --- :  START");
        UserDTO userDTO = userService.findUserByID(id);
        LOGGER.info("[Find User By ID]   --- : END");
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }


    @ApiOperation(value = "Update User", response = UserDTO.class)
    @ApiResponses({
            @ApiResponse(code = 500, message = "Error System")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> findUserByID(@PathVariable
                                          @ApiParam(value = "ID User Need Update") Long id,

                                          @RequestBody
                                          @ApiParam(value = "Update User") UpdateUserRequest updateUserRequest) {
        LOGGER.info("[Find User By ID]   --- :  START");
        UserDTO userDTO = userService.updateUser(updateUserRequest, id);
        LOGGER.info("[Find User By ID]   --- : END");
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }


}
