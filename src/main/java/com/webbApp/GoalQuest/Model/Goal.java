package com.webbApp.GoalQuest.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
public class Goal {

    @Id
    @GeneratedValue
    private int id;

    private String userName;
@Size(min=1, message = "Enter At least a single character ")
    private String goalTitle;

    private LocalDate targetCompletionDate;

    private boolean done;

    @OneToMany
    private List<SubGoal> subGoalList;

    public Goal(int id, String userName, String goalTitle, LocalDate targetCompletionDate, boolean done) {
        this.id = id;
        this.userName = userName;
        this.goalTitle = goalTitle;
        this.targetCompletionDate = targetCompletionDate;
        this.done = done;
    }
    public Goal() {
    }

}
