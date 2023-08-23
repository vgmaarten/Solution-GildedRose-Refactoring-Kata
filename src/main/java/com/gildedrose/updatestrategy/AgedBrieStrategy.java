package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

public final class AgedBrieStrategy extends StandardStrategy {
    public static final String ITEM_NAME = "Aged Brie";

    public AgedBrieStrategy(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
    }

    @Override
    protected void handleExpired() {
        increaseQuality();
    }
}
