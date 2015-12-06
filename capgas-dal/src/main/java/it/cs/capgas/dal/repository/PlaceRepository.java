/**
 * 
 */
package it.cs.capgas.dal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.cs.capgas.entity.Place;

/**
 * Class PlaceRepository
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
public interface PlaceRepository extends PagingAndSortingRepository<Place, Long> {

}
