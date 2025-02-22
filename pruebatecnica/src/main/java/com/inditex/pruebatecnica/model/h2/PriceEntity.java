package com.inditex.pruebatecnica.model.h2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * The type Price entity.
 */
@Entity
@Table(name = "PRICES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceEntity {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The Brand id.
     */
    @Column(name = "BRAND_ID")
    private Integer brandId;
    /**
     * The Start date.
     */
    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    /**
     * The End date.
     */
    @Column(name = "END_DATE")
    private LocalDateTime endDate;
    /**
     * The Price list.
     */
    @Column(name = "PRICE_LIST")
    private Integer priceList;
    /**
     * The Product id.
     */
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    /**
     * The Priority.
     */
    @Column(name = "PRIORITY")
    private Integer priority;
    /**
     * The Price.
     */
    @Column(name = "PRICE")
    private BigDecimal price;
    /**
     * The Curr.
     */
    @Column(name = "CURR")
    private String curr;

}
