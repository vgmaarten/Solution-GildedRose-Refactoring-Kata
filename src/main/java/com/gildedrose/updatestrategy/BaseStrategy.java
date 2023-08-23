package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

public abstract class BaseStrategy {
    protected final Item item;

    protected BaseStrategy(Item item) {
        this.item = item;
    }

    public void doUpdate() {
        updateQuality();
        updateSellIn();

        if (isItemExpired()) {
            handleExpired();
        }
    }
    abstract void updateQuality();

    abstract void handleExpired();

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    protected void updateSellIn() {
        item.sellIn--;
    }

    private boolean isItemExpired() {
        return item.sellIn < 0;
    }
}
