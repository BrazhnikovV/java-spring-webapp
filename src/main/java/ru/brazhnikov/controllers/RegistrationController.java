package ru.brazhnikov.controllers;

import ru.brazhnikov.entities.User;
import ru.brazhnikov.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/add")
    public String showMyLoginPage(User user ) {
        return "users/create";
    }

    // Binding Result после @ValidModel !!!
    @PostMapping("/add")
    public String processRegistrationForm(@Valid User user, BindingResult theBindingResult, Model theModel) {
        String userName = user.getUserName();

        if (theBindingResult.hasErrors()) {
            return "users/create";
        }
        User existing = this.userService.findByUserName(userName);
        if (existing != null) {
            // theSystemUser.setUserName(null);
            theModel.addAttribute("user", user);
            theModel.addAttribute("registrationError", "User name already exists");

            return "users/create";
        }
        Long longTime = new Long(System.currentTimeMillis() / 1000L);

        user.setCreated_at( longTime );
        user.setUpdated_at( longTime );
        this.userService.save( user );

        return "users/create-success";
    }
}
