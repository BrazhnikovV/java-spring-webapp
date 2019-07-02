package ru.brazhnikov.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

/**
 * Role - класс сущность - роль пользователя
 *
 * @version 1.0.1
 * @package ru.brazhnikov.entities
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Getter
@Setter
@Entity
@Table( name = "roles" )
public class Role {

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
     * @var String name - имя
     */
    @Column(name = "name")
    private String name;
}
