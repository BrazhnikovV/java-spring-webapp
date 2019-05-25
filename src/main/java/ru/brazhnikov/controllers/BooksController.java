package ru.brazhnikov.controllers;

import ru.brazhnikov.entities.Book;
import org.springframework.ui.Model;
import ru.brazhnikov.services.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * StudentsController - контроллер для работы со студентами
 *
 * @version 1.0.1
 * @package ru.brazhnikov.controllers
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Controller
@RequestMapping( "/books" )
public class BooksController {

    /**
     *  @access private
     *  @var BooksService booksService - сервис для получения информации о книгах
     */
    private BooksService booksService;

    /**
     * setBooksService
     * @param booksService
     */
    @Autowired
    public void setBooksService( BooksService booksService) {
        this.booksService = booksService;
    }

    /**
     * showBooksList - показать список книг
     * @param model
     * @return String
     */
    @RequestMapping( "/list" )
    public String showBooksList( Model model ) {
        List<Book> allBooks = this.booksService.getAllBooksList();
        model.addAttribute("booksList", allBooks );
        return "books-list";
    }

    /**
     * showAddForm - показать страницу добавления книги
     * @param model
     * @return String
     */
    @RequestMapping( path = "/add", method = RequestMethod.GET )
    public String showAddForm( Model model ) {
        Book book = new Book();
        book.setName( "Unknown" );
        model.addAttribute("book", book );
        return "add-book-form";
    }

    /**
     * showAddForm - форма для отравки данных на сервер
     * @param book - добавляемая книга
     * @return String
     */
    @RequestMapping( path = "/add", method = RequestMethod.POST )
    public String showAddForm( Book book ) {
        String unixTime = String.valueOf( System.currentTimeMillis() / 1000L );
        book.setCreated_at(unixTime);
        book.setUpdated_at(unixTime);
        book.setDescription( "description" );
        book.setYearOfIssue(unixTime);
        this.booksService.addBook( book );
        return "redirect:/books/list";
    }

    /**
     * removeById - удалить книгу
     * @param bookId - идентификатор книги
     * @return
     */
    @RequestMapping( path = "/remove/{id}", method=RequestMethod.GET )
    public String removeById( @PathVariable( value = "id" ) Long bookId ) {
        this.booksService.removeById( bookId );
        return "redirect:/books/list";
    }
}
