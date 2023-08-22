package com.gildedrose;

public class ItemWrapper {
    private final Item item;

    public ItemWrapper(Item item) {
        this.item = item;
    }

    public void update() {
        updateQuality();
        updateSellIn();

        if (isItemExpired()) {
            handleExpiredItem();
        }
    }

    protected void updateQuality() {
        if (item.name.equals(GildedRose.SULFURAS)) {
            return;
        }

        if (item.name.equals(GildedRose.AGED_BRIE)) {
            increaseQuality();
        } else if (item.name.equals(GildedRose.BACKSTAGE_PASSES)) {
            increaseQuality();

            if (item.sellIn < 11) {
                increaseQuality();
            }

            if (item.sellIn < 6) {
                increaseQuality();
            }
        } else decreaseQuality();
    }

    protected void handleExpiredItem() {
        if (item.name.equals(GildedRose.SULFURAS)) {
            return;
        }

        if (item.name.equals(GildedRose.AGED_BRIE)) {
            increaseQuality();
        } else if (item.name.equals(GildedRose.BACKSTAGE_PASSES)) {
            item.quality = 0;
        } else {
            decreaseQuality();
        }
    }

    protected void updateSellIn() {
        if (item.name.equals(GildedRose.SULFURAS)) {
            return;
        }

        item.sellIn = item.sellIn - 1;
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
