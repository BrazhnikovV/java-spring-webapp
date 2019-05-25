package ru.brazhnikov.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Collection;

/**
 * User - класс сущность - пользователь
 *
 * @version 1.0.1
 * @package ru.brazhnikov.entities
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Getter
@Setter
@Entity
@Table( name = "users" )
public class User {

    /**
     * @access private
     * @var int id - перавичный ключ таблицы
     */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Long id;

    /**
     * @access private
     * @var String username - логин
     */
    @Column( name = "username" )
    private String userName;

    /**
     * @access private
     * @var String password - пароль
     */
    @Column( name = "password" )
    private String password;

    /**
     * @access private
     * @var String first_name - имя
     */
    @Column( name = "first_name" )
    private String firstName;

    /**
     * @access private
     * @var String last_name - фамилия
     */
    @Column( name = "last_name" )
    private String lastName;

    /**
     * @access private
     * @var String email - электронная почта
     */
    @Column( name = "email" )
    private String email;

    /**
     * @access private
     * @var String phone - телефон
     */
    @Column( name = "phone" )
    private String phone;

    /**
     * @access private
     * @var Collection<Role> roles - колекция ролей
     */
    @ManyToMany( fetch = FetchType.LAZY )
    @JoinTable( name = "users_roles",
            joinColumns = @JoinColumn( name = "user_id" ),
            inverseJoinColumns = @JoinColumn( name = "role_id" ) )
    private Collection<Role> roles;
}
