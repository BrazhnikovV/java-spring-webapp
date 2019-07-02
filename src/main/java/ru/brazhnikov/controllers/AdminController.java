package ru.brazhnikov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AdminController - контроллер админской части приложения
 *
 * @version 1.0.1
 * @package ru.brazhnikov.controllers
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    /**
     * adminHome - показать главную страницу админской части
     * @return String
     */
    @GetMapping( "" )
    public String adminHome() {
        return "admin/admin-panel";
    }
}
