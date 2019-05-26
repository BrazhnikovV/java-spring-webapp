package ru.brazhnikov.controllers;


import java.util.List;
import javax.validation.Valid;
import java.security.Principal;
import ru.brazhnikov.entities.User;
import org.springframework.ui.Model;
import ru.brazhnikov.entities.Student;
import ru.brazhnikov.services.UserService;
import ru.brazhnikov.services.StudentsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

/**
 * StudentsController - контроллер для работы со студентами
 *
 * @version 1.0.1
 * @package ru.brazhnikov.controllers
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Controller
@RequestMapping( "/students" )
public class StudentsController {

    /**
     *  @access private
     *  @var UserService userService - сервис пользователей
     */
    private UserService userService;

    /**
     * setUserService - прицепить сервис пользователей
     * @param userService - сервис для работы с таблицей users
     */
    @Autowired
    public void setUserService( UserService userService ) {
        this.userService = userService;
    }

    /**
     * initBinder -
     * @param dataBinder
     * @return void
     */
    @InitBinder
    public void initBinder( WebDataBinder dataBinder ) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true );
        dataBinder.registerCustomEditor( String.class, stringTrimmerEditor );
    }

    /**
     *  @access private
     *  @var StudentsService studentsService - сервис для получения информации о студентах
     */
    private StudentsService studentsService;

    /**
     * setStudentsService
     * @param studentsService
     */
    @Autowired
    public void setStudentsService( StudentsService studentsService ) {
        this.studentsService = studentsService;
    }

    /**
     * showStudentsList -
     * @param model
     * @return String
     */
    @Secured({"ROLE_MANAGER","ROLE_ADMIN","ROLE_USER",})
    @RequestMapping( "/list" )
    public String showStudentsList( Model model ) {
        List<Student> allStudents = this.studentsService.getAllStudentsList();
        model.addAttribute("studentsList", allStudents );
        return "students/list";
    }

    /**
     * processAddStudent - добавить нового студента
     * @param student - новый студент
     * @param theBindingResult - какая фигня для валидации
     * @param principal - данные об авторизованном пользователе
     * @return String
     */
    @Secured({"ROLE_MANAGER","ROLE_ADMIN"})
    @RequestMapping( path = "/add", method = RequestMethod.POST )
    public String processAddStudent( @Valid Student student, BindingResult theBindingResult, Principal principal ) {

        if (theBindingResult.hasErrors()) {
            return "students/create";
        }

        User user = this.userService.findByUserName( principal.getName() );
        Long longTime = new Long(System.currentTimeMillis() / 1000L);

        student.setCreated_at( longTime );
        student.setUpdated_at( longTime );
        student.setUserId( user.getId() );
        this.studentsService.addStudent( student );

        return "redirect:/students/list";
    }

    /**
     * showAddForm - показать форму для добавления студента
     * @param student - объект студента
     * @return
     */
    @Secured({"ROLE_MANAGER","ROLE_ADMIN"})
    @RequestMapping( path = "/add", method = RequestMethod.GET )
    public String showAddForm( Student student ) {
        return "students/create";
    }

    /**
     * removeById - удалить студента
     * @param studentId - идентификатор студента
     * @return
     */
    @RequestMapping( path = "/remove/{id}", method=RequestMethod.GET )
    public String removeById( @PathVariable(value = "id") Long studentId ) {
        this.studentsService.removeById( studentId );
        return "redirect:/students/list";
    }
}
