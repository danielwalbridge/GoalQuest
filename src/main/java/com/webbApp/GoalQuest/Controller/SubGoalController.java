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
        return "addSubGoal";
    }

    @RequestMapping(value = "/addSubGoal", method = RequestMethod.POST)
    public String addNewSubGoal(@RequestParam String description, @RequestParam Goal goal,
                                ModelMap modelMap, @Valid SubGoal subGoal, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/addSubGoal";
        }
        subGoal.setDescription(description);
        subGoalRepository.save(subGoal);
        return "redirect:/goals";
    }

    private String getLoggedInUserName(ModelMap modelMap) {
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
