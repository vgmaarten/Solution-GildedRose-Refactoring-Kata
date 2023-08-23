package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

public class ConjuredStrategy extends StandardStrategy {
    public static final String ITEM_NAME_PREFIX = "Conjured";

    public ConjuredStrategy(Item item) {
        super(item);
    }

    @Override
    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality -= 2;
        }
    }
}
