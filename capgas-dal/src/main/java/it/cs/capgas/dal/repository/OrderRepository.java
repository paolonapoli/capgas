/**
 * 
 */
package it.cs.capgas.dal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.cs.capgas.entity.Order;

/**
 * Class OrderRepository
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

}
