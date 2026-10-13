
package com.school;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Locale;

public class FeeHead {

    private String name;
    private BigDecimal amount;

    public FeeHead(String name, BigDecimal amount) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Fee name cannot be empty");
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Fee amount must be greater than zero"
            );
        }

        this.name = name.trim();
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FeeHead)) {
            return false;
        }

        FeeHead other = (FeeHead) obj;
        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(Locale.ROOT));
    }
}
