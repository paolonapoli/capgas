/**
 * 
 */
package it.cs.capgas.dal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.cs.capgas.entity.SolidalGroup;

/**
 * Class SolidalGroupRepository
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
public interface SolidalGroupRepository extends PagingAndSortingRepository<SolidalGroup, Long> {

}
