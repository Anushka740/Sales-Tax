package org.example;

import java.util.Arrays;
import java.util.List;

public class SalesTax {
    public static void main(String[] args) {

        List<Goods> basket1 = Arrays.asList(
                new Goods("book", 12.49, false, true),
                new Goods("music CD", 14.99, false, false),
                new Goods("chocolate bar", 0.85, false, true)
        );

        List<Goods> basket2 = Arrays.asList(
                new Goods("imported box of chocolates", 10.00, true, true),
                new Goods("imported bottle of perfume", 47.50, true, false)
        );

        List<Goods> basket3 = Arrays.asList(
                new Goods("imported bottle of perfume", 27.99, true, false),
                new Goods("bottle of perfume", 18.99, false, false),
                new Goods("packet of headache pills", 9.75, false, true),
                new Goods("box of imported chocolates", 11.25, true, true)
        );


        System.out.println("Output 1:");
        new Receipt(basket1).printReceipt();

        System.out.println("\nOutput 2:");
        new Receipt(basket2).printReceipt();

        System.out.println("\nOutput 3:");
        new Receipt(basket3).printReceipt();
    }
}