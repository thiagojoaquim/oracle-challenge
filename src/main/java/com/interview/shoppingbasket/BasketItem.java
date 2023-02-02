package com.interview.shoppingbasket;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"productCode"})
public class BasketItem {
    private String productCode;
    private String productName;
    private int quantity;
    private double productRetailPrice;
}
