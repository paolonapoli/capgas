/**
 * 
 */
package it.cs.capgas.dal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.cs.capgas.entity.Category;

/**
 * Class CategoryRepository
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

}
