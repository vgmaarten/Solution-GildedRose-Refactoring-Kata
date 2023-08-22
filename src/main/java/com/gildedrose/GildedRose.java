package com.gildedrose;

class GildedRose {
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventoryDaily() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        updateQuality(item);
        updateSellIn(item);

        if (isItemExpired(item)) {
            handleExpiredItem(item);
        }
    }

    private void updateQuality(Item item) {
        if (item.name.equals(SULFURAS)) {
            return;
        }

        if (item.name.equals(AGED_BRIE)) {
            increaseQuality(item);
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            increaseQuality(item);

            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        } else decreaseQuality(item);
    }

    private void updateSellIn(Item item) {
        if (item.name.equals(SULFURAS)) {
            return;
        }

        item.sellIn = item.sellIn - 1;
    }

    private void handleExpiredItem(Item item) {
        if (item.name.equals(SULFURAS)) {
            return;
        }

        if (item.name.equals(AGED_BRIE)) {
            increaseQuality(item);
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            item.quality = 0;
        } else {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private boolean isItemExpired(Item item) {
        return item.sellIn < 0;
    }
}
