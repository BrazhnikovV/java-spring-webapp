package ru.brazhnikov.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "is required")
    @Column( name = "username" )
    private String userName;

    /**
     * @access private
     * @var String password - пароль
     */
    @NotNull(message = "is required")
    @Column( name = "password" )
    private String password;

    /**
     * @access private
     * @var String first_name - имя
     */
    @NotNull(message = "is required")
    @Column( name = "first_name" )
    private String firstName;

    /**
     * @access private
     * @var String last_name - фамилия
     */
    @NotNull(message = "is required")
    @Column( name = "last_name" )
    private String lastName;

    /**
     * @access private
     * @var String email - электронная почта
     */
    @NotNull(message = "is required")
    @Column( name = "email" )
    private String email;

    /**
     * @access private
     * @var String phone - телефон
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
     * @access private
     * @var Collection<Role> roles - колекция ролей
     */
    @ManyToMany( fetch = FetchType.LAZY )
    @JoinTable( name = "users_roles",
            joinColumns = @JoinColumn( name = "user_id" ),
            inverseJoinColumns = @JoinColumn( name = "role_id" ) )
    private Collection<Role> roles;
}
