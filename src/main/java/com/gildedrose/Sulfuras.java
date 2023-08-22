package com.gildedrose;

public class Sulfuras extends WrappedStandardItem {
    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        // Do nothing.
    }

    @Override
    protected void handleExpiredItem() {
        // Do nothing.
    }

    @Override
    protected void updateSellIn() {
        // Do nothing.
    }
}
