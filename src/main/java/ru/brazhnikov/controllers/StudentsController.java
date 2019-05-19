package ru.brazhnikov.controllers;

import java.util.List;
import org.springframework.ui.Model;
import ru.brazhnikov.entities.Student;
import ru.brazhnikov.services.StudentsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping( "/list" )
    public String showStudentsList( Model model ) {
        List<Student> allStudents = this.studentsService.getAllStudentsList();
        model.addAttribute("studentsList", allStudents );
        return "students-list";
    }

    /**
     * showAddForm - показать страницу добавления студента
     * @param model
     * @return String
     */
    @RequestMapping( path="/add", method=RequestMethod.GET )
    public String showAddForm( Model model ) {
        Student student = new Student();
        student.setName( "Unknown" );
        model.addAttribute("student", student );
        return "add-student-form";
    }

    /**
     * showAddForm - форма для отравки данных на сервер
     * @param student - добавляемый студент
     * @return String
     */
    @RequestMapping( path="/add", method=RequestMethod.POST )
    public String showAddForm( Student student ) {
        studentsService.addStudent( student );
        return "redirect:/students/list";
    }

    /**
     * removeById - удалить студента
     * @param studentId - идентификатор студента
     * @return
     */
    @RequestMapping( path = "/remove/{id}", method=RequestMethod.GET )
    public String removeById( @PathVariable(value = "id") Long studentId ) {
        studentsService.removeById( studentId );
        return "redirect:/students/list";
    }
}
