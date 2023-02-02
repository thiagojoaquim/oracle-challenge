package com.interview.shoppingbasket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Basket {
    private List<BasketItem> items = new ArrayList<>();

    public void add(String productCode, String productName, int quantity) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProductCode(productCode);
        basketItem.setProductName(productName);
        basketItem.setQuantity(quantity);

        items.add(basketItem);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void consolidateItems() {
        HashMap<String, BasketItem> consolidatedItems = new HashMap<>();
        for (var item : items) {
            var possibleExistentItem = consolidatedItems.get(item.getProductCode());
            if (Objects.nonNull(possibleExistentItem)) {
                possibleExistentItem.setQuantity(possibleExistentItem.getQuantity() + item.getQuantity());
            } else {
                consolidatedItems.put(item.getProductCode(), item);
            }
        }
        items = consolidatedItems.values().stream().collect(Collectors.toList());
    }
}
