package com.gildedrose;

import com.gildedrose.updatestrategy.UpdateStrategyFactory;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventoryDaily() {
        for (Item item : items) {
            UpdateStrategyFactory.create(item).doUpdate();
        }
    }
}
