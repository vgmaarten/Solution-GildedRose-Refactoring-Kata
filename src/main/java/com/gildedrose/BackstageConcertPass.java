package com.gildedrose;

public class BackstageConcertPass extends WrappedStandardItem {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstageConcertPass(Item item) {
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
