package com.ndangduc.bn.usermanagement.service.impl;

import com.ndangduc.bn.usermanagement.controller.UserRestController;
import com.ndangduc.bn.usermanagement.entity.User;
import com.ndangduc.bn.usermanagement.exception.DuplicatedException;
import com.ndangduc.bn.usermanagement.exception.ErrorSaveException;
import com.ndangduc.bn.usermanagement.exception.NotFoundException;
import com.ndangduc.bn.usermanagement.model.mapper.UserMapper;
import com.ndangduc.bn.usermanagement.model.request.CreateUserRequest;
import com.ndangduc.bn.usermanagement.model.request.UpdateUserRequest;
import com.ndangduc.bn.usermanagement.model.response.UserDTO;
import com.ndangduc.bn.usermanagement.repository.UserRepository;
import com.ndangduc.bn.usermanagement.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements IUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO createUser(CreateUserRequest createUserRequest) {
        LOGGER.info("[Create User]   --- :  Call Service createUser");

        // Kiểm tra xem user đã tồn tại chưa. Nếu có bắn ra Exception
        boolean isEmailExist = userRepository.existsByEmail(createUserRequest.getEmail());
        LOGGER.info("[Create User]   --- :  Check Exists: " + isEmailExist);
        if (isEmailExist) {
            throw new DuplicatedException("User existed in My System");
        }

        // Convert Model Request sang Entity
        User user = UserMapper.convertToUser(createUserRequest);

        // Lưu User mới trong DB
        userRepository.save(user);

        // Trả ra kết quả cho Client
        LOGGER.info("[Create User]   --- : Result Call\n" + user);
        return UserMapper.convertToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUser() {
        LOGGER.info("[Get All User]   --- :  Call Service Get All User");
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        userList.forEach(u -> {
            userDTOS.add(UserMapper.convertToUserDTO(u));
        });
        LOGGER.info("[Get All User]   --- :  Result Call\n" + userDTOS);
        return userDTOS;
    }

    @Override
    public UserDTO findUserByID(long id) {
        LOGGER.info("[Find User By ID]   --- :  Call Service Find  User By ID");
        Optional<User> user = userRepository.findById(id);
        if (user != null) {
            return UserMapper.convertToUserDTO(user.get());
        }
        throw new NotFoundException("Can not find this User have ID = " + id);
    }

    @Override
    public UserDTO updateUser(UpdateUserRequest updateUserRequest, long id) {
        LOGGER.info("[Update User]   --- :  Call Service Update ");
        Optional<User> user = userRepository.findById(id);
        if (user != null) {
            User userUpdate = UserMapper.convertToUser(updateUserRequest, id);
            try {
                userRepository.save(userUpdate);
            } catch (Exception e) {
                throw new ErrorSaveException("Can not Save to Database");
            }
            LOGGER.info("[Update User]   --- :  Result Call\n" + userUpdate);
            return UserMapper.convertToUserDTO(userUpdate);
        }
        throw new NotFoundException("Can not Update this User have ID = " + id);
    }

    @Override
    public void deleteUser(Long id) {
        LOGGER.info("[Update User]   --- :  Call Service Update ");
        Optional<User> user = userRepository.findById(id);
        if (user != null) {
            userRepository.deleteById(id);
            LOGGER.info("[Update User]   --- :  Result Call\n");
        } else {
            throw new NotFoundException("Can not Delete this User have ID = " + id);
        }
    }
}
