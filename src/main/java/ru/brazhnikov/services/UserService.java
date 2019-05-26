package ru.brazhnikov.services;

import ru.brazhnikov.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * UserService - интерфейс
 *
 * @version 1.0.1
 * @package ru.brazhnikov.services
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public interface UserService extends UserDetailsService {

    /**
     * findByUserName - найти пользователя по именю
     * @param userName
     * @return
     */
    User findByUserName( String userName );

    /**
     * save - сохранить пользователя
     * @param user
     */
    void save( User user );
}
