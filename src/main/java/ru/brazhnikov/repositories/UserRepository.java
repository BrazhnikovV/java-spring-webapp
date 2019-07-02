package ru.brazhnikov.repositories;

import ru.brazhnikov.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * UserRepository - интерфейс
 *
 * @version 1.0.1
 * @package ru.brazhnikov.repositories
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * findOneByUserName - найти пользователя по имени
     * @param userName - имя пользователя
     * @return User
     */
    User findOneByUserName( String userName );
}
