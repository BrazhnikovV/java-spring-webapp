package ru.brazhnikov.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

/**
 * Book - класс - сущность книги
 *
 * @version 1.0.1
 * @package ru.brazhnikov.entities
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Getter
@Setter
@Entity
@Table( name = "books" )
public class Book {
    /**
     *  @access private
     *  @var Long id - идентификатор книги
     */
    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    /**
     *  @access private
     *  @var String name - название книги
     */
    @Column( name = "name" )
    private String name;

    /**
     *  @access private
     *  @var String description - описание книги
     */
    @Column( name = "description" )
    private String description;

    /**
     *  @access private
     *  @var String description - год выпуска книги
     */
    @Column( name = "year_of_issue" )
    private String year_of_issue;

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
}
