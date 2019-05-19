package ru.brazhnikov.services;

import java.util.List;

import ru.brazhnikov.entities.Book;
import org.springframework.stereotype.Service;
import ru.brazhnikov.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * BooksService - сервис для работы с данными о книгах
 *
 * @version 1.0.1
 * @package ru.brazhnikov.services
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Service
public class BooksService {

    /**
     *  @access private
     *  @var BooksRepository booksRepository - репозиторий книг
     */
    private BooksRepository booksRepository;

    /**
     * setStudentsRepository -
     * @param booksRepository
     * @return void
     */
    @Autowired
    public void setStudentsRepository( BooksRepository booksRepository ) {
        this.booksRepository = booksRepository;
    }

    /**
     * BooksService - конструктор
     */
    public BooksService() {}

    /**
     * getAllBooksList - получить список книг
     * @return List<Book>
     */
    public List<Book> getAllBooksList() {
        return ( List<Book> ) this.booksRepository.findAll();
    }

    /**
     * addBook - добавить новуб книгу
     * @param b - объект книги
     * @return void
     */
    public void addBook( Book b )  {
        this.booksRepository.save( b );
    }

    /**
     * removeById - удалить книгу по идентификатору
     * @param id - идентификатор книги
     * @return void
     */
    public void removeById( Long id ) {
        this.booksRepository.deleteById( id );
    }
}
