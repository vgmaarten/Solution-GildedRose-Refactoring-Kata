package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

public final class ConjuredStrategy extends BaseStrategy {
    public static final String ITEM_NAME_PREFIX = "Conjured";

    public ConjuredStrategy(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        decreaseQuality();
    }

    @Override
    void handleExpired() {
        decreaseQuality();
    }

    @Override
    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality -= 2;
        }
    }
}
