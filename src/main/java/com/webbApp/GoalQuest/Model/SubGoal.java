package com.webbApp.GoalQuest.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class SubGoal {

    @Id
    @GeneratedValue
    private Long ID;

    private String description;
}
