package com.webbApp.GoalQuest.Controller;

import com.webbApp.GoalQuest.Model.Goal;
import com.webbApp.GoalQuest.Repository.GoalRepository;
import com.webbApp.GoalQuest.Repository.SubGoalRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("name")
public class GoalController {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private SubGoalRepository subGoalRepository;

    @RequestMapping("/goals")
    public String gotoGoalsPageAndListAllGoals(ModelMap modelMap) {
        String userName = getLoggedInUserName(modelMap);

        List<Goal> goals =goalRepository.findByUserName(userName);
        modelMap.put("userGoals", goals);
        return "goalsPage";
    }



    @RequestMapping(value = "/addGoal", method = RequestMethod.GET)
    public String showNewGoalPage(ModelMap modelMap) {
        String userName =  getLoggedInUserName(modelMap);
        Goal goal = new Goal(0,userName,"Enter Goal title here", LocalDate.now().plusDays(2), false, new ArrayList<>());
        modelMap.put("goal", goal);
        return "addGoal";
    }

    @RequestMapping(value = "/addGoal", method = RequestMethod.POST)
    public String addNewGoal(ModelMap modelMap, @Valid Goal goal, BindingResult result) {

        if (result.hasErrors()) {
            return "addGoal";
        }
        String userName = getLoggedInUserName(modelMap);
        goal.setUserName(userName);
        goalRepository.save(goal);
        return "redirect:/goals";
    }

    @RequestMapping(value = "/deleteGoal")
    public String deleteGoal(@RequestParam int id) {
        subGoalRepository.deleteAll();
        goalRepository.deleteById(id);
        return "redirect:/goals";
    }

    @RequestMapping(value = "/updateGoal", method = RequestMethod.GET)
    public String gotoUpdateGoalPage(@RequestParam int id, ModelMap modelMap) {
        Goal goal = goalRepository.findById(id).get();
        modelMap.addAttribute("goal", goal);
        return "updateGoalPage";
    }

    @RequestMapping(value = "/updateGoal", method = RequestMethod.POST)
    public String updateGoal(ModelMap modelMap, @Valid Goal goal, BindingResult result) {

        if (result.hasErrors()) {
            return "addGoal";
        }
        String userName = getLoggedInUserName(modelMap);
        goal.setUserName(userName);
        goalRepository.save(goal);
        return "redirect:/goals";
    }
    private String getLoggedInUserName(ModelMap modelMap) {
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
