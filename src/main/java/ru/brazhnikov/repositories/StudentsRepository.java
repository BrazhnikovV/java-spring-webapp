package ru.brazhnikov.repositories;

import ru.brazhnikov.entities.Student;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * StudentsRepository - интерфейс
 *
 * @version 1.0.1
 * @package ru.brazhnikov.repositories
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Repository
public interface StudentsRepository extends PagingAndSortingRepository<Student, Long> {

}
