package org.example;

import java.math.BigDecimal;

class Goods {
    private final String name;
    private final BigDecimal price;
    private final boolean isImported;
    private final boolean isExempt;

    public Goods(String name, double price, boolean isImported, boolean isExempt) {
        this.name = name;
        this.price = BigDecimal.valueOf(price);
        this.isImported = isImported;
        this.isExempt = isExempt;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isExempt() {
        return isExempt;
    }
}