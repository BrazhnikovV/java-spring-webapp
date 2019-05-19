package ru.brazhnikov.repositories;

import ru.brazhnikov.entities.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * BooksRepository - интерфейс
 *
 * @version 1.0.1
 * @package ru.brazhnikov.repositories
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Repository
public interface BooksRepository extends PagingAndSortingRepository<Book, Long> {

}
