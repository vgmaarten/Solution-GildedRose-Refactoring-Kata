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
            if (item.quality < 50) {
                item.quality++;
            }
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            if (item.quality < 50) {
                item.quality++;

                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                        item.quality++;
                    }
                }

                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        item.quality++;
                    }
                }
            }
        } else if (item.quality > 0) {
            item.quality--;
        }
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void handleExpiredItem(Item item) {
        if (!item.name.equals(AGED_BRIE)) {
            if (!item.name.equals(BACKSTAGE_PASSES)) {
                if (item.quality > 0) {
                    if (!item.name.equals(SULFURAS)) {
                        item.quality--;
                    }
                }
            } else {
                item.quality = 0;
            }
        } else {
            if (item.quality < 50) {
                item.quality++;
            }
        }
    }

    private boolean isItemExpired(Item item) {
        return item.sellIn < 0;
    }
}
