package ru.brazhnikov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * LoginController - контроллер для логина пользователей
 *
 * @version 1.0.1
 * @package ru.brazhnikov.controllers
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Controller
public class LoginController {

    /**
     * showMyLoginPage - показать страницу логина
     * @return String
     */
    @GetMapping( "/login" )
    public String showMyLoginPage() {
        return "modern-login";
    }

    /**
     * showAccessDeniedPage - показать страницу
     * @return String
     */
    @GetMapping("/accessDenied")
    public String showAccessDeniedPage() {
        return "access-denied";
    }
}
