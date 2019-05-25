package ru.brazhnikov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MainController - контроллер главной страницы приложения
 *
 * @version 1.0.1
 * @package ru.brazhnikov.controllers
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Controller
public class MainController {

    /**
     * showHomePage -
     * @return String
     */
    @RequestMapping( "/" )
    public String showHomePage() {
        return "index";
    }

    /**
     * showProfilePage -
     * @return String
     */
    @RequestMapping( "/profile" )
    public String showProfilePage() {
        return "profile";
    }
}
