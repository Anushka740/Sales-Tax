package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final List<Goods> goods;
    private final List<String> receiptLines = new ArrayList<>();
    private BigDecimal totalTaxes = BigDecimal.ZERO;
    private BigDecimal totalCost = BigDecimal.ZERO;

    /**
     * Constructor for the Receipt class.
     *
     * @param goods List of goods to be included in the receipt.
     */
    public Receipt(List<Goods> goods) {
        this.goods = goods;
        calculateReceipt();
    }

    /**
     * Calculates the total taxes and total cost for the goods in the receipt.
     * This method iterates through each item, calculates its tax, and adds the taxed price to the receipt.
     */
    private void calculateReceipt() {
        for (Goods goods : this.goods) {
            BigDecimal itemTax = calculateTax(goods);
            BigDecimal itemTotalPrice = goods.getPrice().add(itemTax);

            totalTaxes = totalTaxes.add(itemTax);
            totalCost = totalCost.add(itemTotalPrice);

            receiptLines.add(String.format("1 %s: %.2f", goods.getName(), itemTotalPrice));
        }
    }

    /**
     * Calculates the sales tax for a given item.
     * Applies a 10% basic sales tax if the item is not exempt,
     * and an additional 5% import duty if the item is imported.
     *
     * @param goods The goods for which the tax is to be calculated.
     * @return The total tax for the item, rounded up to the nearest 0.05.
     */
    private BigDecimal calculateTax(Goods goods) {
        BigDecimal tax = BigDecimal.ZERO;

        if (!goods.isExempt()) {
            tax = tax.add(goods.getPrice().multiply(BigDecimal.valueOf(0.10)));
        }

        if (goods.isImported()) {
            tax = tax.add(goods.getPrice().multiply(BigDecimal.valueOf(0.05)));
        }

        return roundUpToNearestFiveCents(tax);
    }

    /**
     * Rounds up a given amount to the nearest 0.05.
     *
     * @param amount The amount to be rounded.
     * @return The rounded amount.
     */
    private BigDecimal roundUpToNearestFiveCents(BigDecimal amount) {
        return amount.divide(BigDecimal.valueOf(0.05), 0, RoundingMode.UP).multiply(BigDecimal.valueOf(0.05));
    }

    /**
     * Prints the receipt, including the name and price of each item,
     * as well as the total sales taxes and total cost.
     */
    public void printReceipt() {
        for (String line : receiptLines) {
            System.out.println(line);
        }
        System.out.printf("Sales Taxes: %.2f%n", totalTaxes);
        System.out.printf("Total: %.2f%n", totalCost);
    }
}
