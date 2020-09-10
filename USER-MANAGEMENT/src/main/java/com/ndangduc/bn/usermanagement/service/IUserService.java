package com.ndangduc.bn.usermanagement.service;

import com.ndangduc.bn.usermanagement.entity.User;
import com.ndangduc.bn.usermanagement.model.request.CreateUserRequest;
import com.ndangduc.bn.usermanagement.model.request.UpdateUserRequest;
import com.ndangduc.bn.usermanagement.model.response.UserDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    UserDTO createUser(CreateUserRequest createUserRequest);
    List<UserDTO> getAllUser();
    UserDTO findUserByID(long id);
    UserDTO updateUser(UpdateUserRequest updateUserRequest, long id);
    void deleteUser(Long id);
    List<UserDTO> getUserByUserNameOrEmail(String username,String email);
}
