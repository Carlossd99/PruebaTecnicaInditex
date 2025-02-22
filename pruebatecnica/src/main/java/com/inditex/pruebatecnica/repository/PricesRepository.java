package com.inditex.pruebatecnica.repository;

import com.inditex.pruebatecnica.model.h2.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * The interface Prices repository.
 */
@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Long> {

    /**
     * Find price list.
     *
     * @param productId the product id
     * @param brandId   the brand id
     * @param date      the date
     * @return the list
     */
    @Query(value = "SELECT * FROM prices " +
            "WHERE PRODUCT_ID = :productId " +
            "AND BRAND_ID = :brandId " +
            "AND :date BETWEEN START_DATE AND END_DATE " +
            "ORDER BY PRIORITY DESC LIMIT 1", nativeQuery = true)
    Optional<PriceEntity> findPrice(@Param("productId") int productId, @Param("brandId") int brandId, @Param("date") LocalDateTime date);


    /**
     * Find by product id and brand id and start date before and end date after order by priority desc list.
     *
     * @param productId the product id
     * @param brandId   the brand id
     * @param date      the date
     * @return the list
     */
    //List<PriceEntity> findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(int productId, int brandId, LocalDateTime date);


    /**
     * Find by product id and brand id and start date before and end date after order by priority desc list.
     *
     * @return the list
     */
    @Query(value = "SELECT * FROM prices", nativeQuery = true)
    List<PriceEntity> findAllPrices();
}
