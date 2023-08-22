package com.gildedrose;

public class WrappedStandardItem {

    protected final Item item;

    public WrappedStandardItem(Item item) {
        this.item = item;
    }

    public static WrappedStandardItem create(Item item) {
        if (item.name.equals(AgedBrie.NAME)) {
            return new AgedBrie(item);
        }

        if (item.name.equals(BackstageConcertPass.NAME)) {
            return new BackstageConcertPass(item);
        }

        if (item.name.equals(Sulfuras.NAME)) {
            return new Sulfuras(item);
        }

        if (item.name.contains(Conjured.NAME)) {
            return new Conjured(item);
        }

        return new WrappedStandardItem(item);
    }

    public void update() {
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
