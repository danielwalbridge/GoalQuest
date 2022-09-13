package com.webbApp.GoalQuest.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;

    private String username;

    @Email
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private String role;
    @OneToMany
    private List<Goal> goalList;


    public User(Long userID, String username, String firstName, String lastName, String password, ArrayList<Goal> goalList) {
        this.userID = userID;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.goalList = goalList;
    }

    public User() {

    }
}
