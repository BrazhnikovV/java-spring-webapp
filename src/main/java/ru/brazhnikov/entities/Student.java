package ru.brazhnikov.entities;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 * Student - класс сущность студента
 *
 * @version 1.0.1
 * @package ru.brazhnikov.entities
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Getter
@Setter
@Entity
@Table( name = "students" )
public class Student {

    /**
     *  @access private
     *  @var Long id - идентификатор студента
     */
    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    /**
     *  @access private
     *  @var String name - имя студента
     */
    @Column( name = "name" )
    private String name;

    /**
     *  @access private
     *  @var String description - описание студента
     */
    @Column( name = "description" )
    private String description;

    /**
     *  @access private
     *  @var String created_at - время создания записи
     */
    @Column( name = "created_at" )
    private String created_at;

    /**
     *  @access private
     *  @var String updated_at - время обновления записи
     */
    @Column( name = "updated_at" )
    private String updated_at;

    /**
     *  @access private
     *  @var List<Course> - список курсов, которые проходит студент
     */
    @ManyToMany
    @JoinTable(
            name = "cours_studs",
            joinColumns = @JoinColumn( name = "student_id" ),
            inverseJoinColumns = @JoinColumn( name = "course_id" )
    )
    @Cascade( {org.hibernate.annotations.CascadeType.DELETE, org.hibernate.annotations.CascadeType.DETACH} )
    private List<Course> courses;

    /**
     * Student - конструктор
     */
    public Student() {}
}
