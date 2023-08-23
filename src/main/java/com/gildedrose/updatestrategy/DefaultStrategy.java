package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

public class DefaultStrategy extends BaseStrategy {
    public DefaultStrategy(Item item) {
        super(item);
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    protected void handleExpired() {
        decreaseQuality();
    }
}
