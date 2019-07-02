package ru.brazhnikov.repositories;

import ru.brazhnikov.entities.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * RoleRepository - интерфейс
 *
 * @version 1.0.1
 * @package ru.brazhnikov.repositories
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

	/**
	 * findOneByName - найти роль по имени
	 * @param theRoleName - название роли
	 * @return Role
	 */
	Role findOneByName( String theRoleName );
}
