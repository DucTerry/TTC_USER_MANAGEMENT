package com.ndangduc.bn.usermanagement.model.mapper;

import com.ndangduc.bn.usermanagement.entity.User;
import com.ndangduc.bn.usermanagement.model.request.CreateUserRequest;
import com.ndangduc.bn.usermanagement.model.request.UpdateUserRequest;
import com.ndangduc.bn.usermanagement.model.response.UserDTO;
import org.mindrot.jbcrypt.BCrypt;

public class UserMapper {
    public static UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setAddress(user.getAddress());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        return userDTO;
    }


    public static User convertToUser(CreateUserRequest createUserRequest) {
        User user = new User();

        user.setUserName(createUserRequest.getUserName());
        user.setAddress(createUserRequest.getAddress());
        user.setEmail(createUserRequest.getEmail());
        user.setPhone(createUserRequest.getPhone());
        // Mã hóa Pasword với round = 12
        String passwordEncoded = BCrypt.hashpw(createUserRequest.getPassword(), BCrypt.gensalt(12));
        user.setPassword(passwordEncoded);
        return user;
    }


    public static User convertToUser(UpdateUserRequest updateUserRequest, long id) {
        User user = new User();

        user.setId(id);
        user.setUserName(updateUserRequest.getUserName());
        user.setAddress(updateUserRequest.getAddress());
        user.setEmail(updateUserRequest.getEmail());
        user.setPhone(updateUserRequest.getPhone());
        // Mã hóa Pasword với round = 12
        String passwordEncoded = BCrypt.hashpw(updateUserRequest.getPassword(), BCrypt.gensalt(12));
        user.setPassword(passwordEncoded);
        return user;
    }
}
