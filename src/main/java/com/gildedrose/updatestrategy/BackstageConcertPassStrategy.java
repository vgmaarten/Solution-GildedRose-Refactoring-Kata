package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

public final class BackstageConcertPassStrategy extends StandardStrategy {
    public static final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstageConcertPassStrategy(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();

        if (item.sellIn < 11) {
            increaseQuality();
        }

        if (item.sellIn < 6) {
            increaseQuality();
        }
    }

    @Override
    protected void handleExpiredItem() {
        item.quality = 0;
    }
}
