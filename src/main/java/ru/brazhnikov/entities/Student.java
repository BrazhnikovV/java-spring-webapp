package ru.brazhnikov.entities;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
     *  @var Long userId - идентификатор пользователя добавившего студента
     */
    @Column( name = "user_id" )
    private Long userId;

    /**
     *  @access private
     *  @var String name - имя студента
     */
    @NotNull(message = "is required")
    @Column( name = "name" )
    private String name;

    /**
     *  @access private
     *  @var String lastName - фамилия студента
     */
    @NotNull(message = "is required")
    @Column( name = "last_name" )
    private String lastName;

    /**
     *  @access private
     *  @var String email - email студента
     */
    @NotNull(message = "is required")
    @Column( name = "email" )
    private String email;

    /**
     *  @access private
     *  @var String phone - телефон студента
     */
    @NotNull(message = "is required")
    @Column( name = "phone" )
    private String phone;

    /**
     *  @access private
     *  @var String created_at - время создания записи
     */
    @Column( name = "created_at" )
    private Long created_at;

    /**
     *  @access private
     *  @var String updated_at - время обновления записи
     */
    @Column( name = "updated_at" )
    private Long updated_at;

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
}
