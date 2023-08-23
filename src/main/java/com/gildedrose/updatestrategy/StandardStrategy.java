package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

public class StandardStrategy {

    protected final Item item;

    public StandardStrategy(Item item) {
        this.item = item;
    }

    public void doUpdate() {
        updateQuality();
        updateSellIn();

        if (isItemExpired()) {
            handleExpiredItem();
        }
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    protected void handleExpiredItem() {
        decreaseQuality();
    }

    protected void updateSellIn() {
        item.sellIn--;
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected boolean isItemExpired() {
        return item.sellIn < 0;
    }

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
