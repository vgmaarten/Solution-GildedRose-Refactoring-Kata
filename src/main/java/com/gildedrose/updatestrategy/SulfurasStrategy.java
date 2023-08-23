package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

public final class SulfurasStrategy extends BaseStrategy {
    public static final String ITEM_NAME = "Sulfuras, Hand of Ragnaros";

    public SulfurasStrategy(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        // Do nothing.
    }

    @Override
    protected void handleExpired() {
        // Do nothing.
    }

    @Override
    protected void updateSellIn() {
        // Do nothing.
    }
}
