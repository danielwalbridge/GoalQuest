package com.webbApp.GoalQuest.Controller;

import com.webbApp.GoalQuest.Model.Goal;
import com.webbApp.GoalQuest.Model.SubGoal;
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

import java.util.ArrayList;
import java.util.List;


@Controller
@SessionAttributes("name")
public class SubGoalController {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private SubGoalRepository subGoalRepository;

    @RequestMapping(value = "/addSubGoal", method = RequestMethod.GET)
    public String showNewSubGoalPage(@RequestParam Integer id, ModelMap modelMap) {
        Goal goal = goalRepository.findById(id).get();
        SubGoal subGoal = new SubGoal(0L, goal,"");
        modelMap.addAttribute("subGoal", subGoal);
        modelMap.addAttribute("goal", goal);
        return "addSubGoal";
    }

    @RequestMapping(value = "/addSubGoal", method = RequestMethod.POST)
    public String addNewSubGoal(@RequestParam String description, @RequestParam Goal goal,
                                ModelMap modelMap, @Valid SubGoal subGoal, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/goals";
        }
        subGoal.setDescription(description);
        subGoalRepository.save(subGoal);
        return "redirect:/goals";
    }

    @RequestMapping(value = "/viewSubGoals", method = RequestMethod.GET)
    public String showSubGoalsPage(@RequestParam(required = false) Integer id, ModelMap modelMap) {
        Goal goal = goalRepository.findById(id).get();
        List<SubGoal> subGoalArrayList = subGoalRepository.findAll();
        List<SubGoal> goalToSubGoal = new ArrayList<>();

        for (SubGoal subGoal:subGoalArrayList) {
            if (subGoal.getGoal().getId()== id) {
                goalToSubGoal.add(subGoal);
            }
        }
        modelMap.addAttribute("subGoals", goalToSubGoal);
        modelMap.addAttribute("goal", goal);
        return "subGoalsPage";
    }

    @RequestMapping(value = "/deleteSubGoal")
    public String deleteGoal(@RequestParam Long id) {
        subGoalRepository.deleteById(id);
        return "redirect:/goals";
    }

    @RequestMapping(value = "/updateSubGoal", method = RequestMethod.GET)
    public String gotoUpdateGoalPage(@RequestParam Long id, ModelMap modelMap) {
        SubGoal subGoal = subGoalRepository.findById(id).get();
        modelMap.addAttribute("subGoal", subGoal);
        return "updateSubGoal";
    }

    @RequestMapping(value = "/updateSubGoal", method = RequestMethod.POST)
    public String updateGoal(ModelMap modelMap, @Valid SubGoal subgoal, BindingResult result) {

        if (result.hasErrors()) {
            return "addSubGoal";
        }
        subGoalRepository.save(subgoal);
        return "redirect:/goals";
    }

    private String getLoggedInUserName(ModelMap modelMap) {
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    //todo build up sublist controller and methods
    // update delete method to handle subgoals

}
