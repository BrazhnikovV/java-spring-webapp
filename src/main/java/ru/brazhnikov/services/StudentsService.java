package ru.brazhnikov.services;

import java.util.List;
import ru.brazhnikov.entities.Student;
import org.springframework.stereotype.Service;
import ru.brazhnikov.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * StudentsService - сервис для работы с данными о студентах
 *
 * @version 1.0.1
 * @package ru.brazhnikov.services
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Service
public class StudentsService {

    /**
     *  @access private
     *  @var StudentsRepository studentsRepository - репозиторий студентов
     */
    private StudentsRepository studentsRepository;

    /**
     * setStudentsRepository -
     * @param studentsRepository
     * @return void
     */
    @Autowired
    public void setStudentsRepository( StudentsRepository studentsRepository ) {
        this.studentsRepository = studentsRepository;
    }

    /**
     * StudentsService - конструктор
     */
    public StudentsService() {}

    /**
     * getAllStudentsList - получить список студентов
     * @return List<Student>
     */
    public List<Student> getAllStudentsList() {
        return ( List<Student> ) this.studentsRepository.findAll();
    }

    /**
     * addStudent - добавить нового студента
     * @param s - объект студента
     * @return void
     */
    public void addStudent( Student s)  {
        this.studentsRepository.save(s);
    }

    /**
     * removeById - удалить студента по идентификатору
     * @param id - идентификатор студента
     * @return void
     */
    public void removeById( Long id ) {
        this.studentsRepository.deleteById( id );
    }
}
