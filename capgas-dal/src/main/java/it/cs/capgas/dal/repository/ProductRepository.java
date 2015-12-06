/**
 * 
 */
package it.cs.capgas.dal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.cs.capgas.entity.Product;

/**
 * Class ProductRepository
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
