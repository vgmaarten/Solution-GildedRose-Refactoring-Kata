package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

public final class SulfurasStrategy extends StandardStrategy {
    public static final String ITEM_NAME = "Sulfuras, Hand of Ragnaros";

    public SulfurasStrategy(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        // Do nothing.
    }

    @Override
    protected void handleExpiredItem() {
        // Do nothing.
    }

    @Override
    protected void updateSellIn() {
        // Do nothing.
    }
}
