package com.dev.warehouse.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

import static com.dev.warehouse.domain.model.StockStatus.UNAVAILABLE;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Long amount;
    private BigDecimal boughtPrice;

    @Enumerated(EnumType.STRING)
    private StockStatus status;

    private BigDecimal soldPrice;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    
    public void decAmount() {
        this.amount -= 1;

        if (this.amount == 0) {
            this.status = UNAVAILABLE;
        }
    }

    public boolean isUnavailable() {
        return this.status.equals(UNAVAILABLE);
    }
}
