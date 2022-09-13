package com.webbApp.GoalQuest.Repository;

import com.webbApp.GoalQuest.Model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GoalRepository extends JpaRepository<Goal, Integer> {

    public List<Goal> findByUserName(String userName);
}
