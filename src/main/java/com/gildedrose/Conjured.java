package com.gildedrose;

public class Conjured extends WrappedStandardItem {
    public static final String NAME = "Conjured";

    public Conjured(Item item) {
        super(item);
    }

    @Override
    protected void decreaseQuality() {
        item.quality -= 2;
    }
}
