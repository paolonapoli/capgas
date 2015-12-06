/**
 *
 */
package it.cs.capgas.dal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.cs.capgas.entity.Group;

/**
 * Class GroupRepository
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
public interface GroupRepository extends PagingAndSortingRepository<Group, Long> {

}
