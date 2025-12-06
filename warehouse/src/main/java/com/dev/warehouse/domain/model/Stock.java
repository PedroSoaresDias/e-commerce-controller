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

    public void decAmount() {
        this.amount -= 1;

        if (this.amount == 0) {
            this.status = UNAVAILABLE;
        }
    }

    public boolean isUnavailable() {
        return status == UNAVAILABLE;
    }

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        result = prime * result + ((boughtPrice == null) ? 0 : boughtPrice.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((soldPrice == null) ? 0 : soldPrice.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Stock other = (Stock) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (amount == null) {
            if (other.amount != null)
                return false;
        } else if (!amount.equals(other.amount))
            return false;
        if (boughtPrice == null) {
            if (other.boughtPrice != null)
                return false;
        } else if (!boughtPrice.equals(other.boughtPrice))
            return false;
        if (status != other.status)
            return false;
        if (soldPrice == null) {
            if (other.soldPrice != null)
                return false;
        } else if (!soldPrice.equals(other.soldPrice))
            return false;
        return true;
    }
}
