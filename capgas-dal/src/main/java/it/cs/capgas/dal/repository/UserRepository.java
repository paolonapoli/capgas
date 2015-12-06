/**
 *
 */
package it.cs.capgas.dal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.cs.capgas.entity.User;

/**
 * Class UserRepository
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {

}
