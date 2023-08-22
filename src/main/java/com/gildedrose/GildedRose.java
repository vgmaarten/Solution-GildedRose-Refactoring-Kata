package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventoryDaily() {
        for (Item item : items) {
            WrappedStandardItem.create(item).update();
        }
    }
}
