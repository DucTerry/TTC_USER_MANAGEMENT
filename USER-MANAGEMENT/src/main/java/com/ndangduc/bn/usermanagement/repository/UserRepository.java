package com.ndangduc.bn.usermanagement.repository;

import com.ndangduc.bn.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    @Query("Select u from User u where u.userName like %:username% and u.email like %:email% order by u.userName desc ")
    List<User> getUserByUserNameOrEmail(@Param("username") String username, @Param("email") String email);
}
