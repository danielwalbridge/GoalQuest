package com.webbApp.GoalQuest.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class SubGoal {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    @ManyToOne
    private Goal goal;


    public SubGoal( Long id,Goal goal, String description) {
        this.id=id;
        this.goal = goal;
        this.description=description;
    }

    public SubGoal() {

    }
}
