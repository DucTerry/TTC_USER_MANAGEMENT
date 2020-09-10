package com.ndangduc.bn.usermanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_name")
    private String userName;


    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone", length = 11)
    private String phone;

}
