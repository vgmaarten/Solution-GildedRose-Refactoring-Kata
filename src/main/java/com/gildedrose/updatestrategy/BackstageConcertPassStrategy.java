package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

public final class BackstageConcertPassStrategy extends BaseStrategy {
    public static final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstageConcertPassStrategy(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();

        if (item.sellIn <= 10) {
            increaseQuality();
        }

        if (item.sellIn <= 5) {
            increaseQuality();
        }
    }

    @Override
    protected void handleExpired() {
        item.quality = 0;
    }
}
