package ru.brazhnikov.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MainController - контроллер главной страницы приложения
 *
 * @version 1.0.1
 * @package ru.brazhnikov.controllers
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public class MainController {

    /**
     * showHomePage -
     * @return String
     */
    @RequestMapping( "/" )
    public String showHomePage() {
        return "index";
    }
}
