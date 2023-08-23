package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

public final class UpdateStrategyFactory {
    public static BaseStrategy create(Item item) {
        if (item.name.contains(ConjuredStrategy.ITEM_NAME_PREFIX)) {
            return new ConjuredStrategy(item);
        }

        switch (item.name) {
            case AgedBrieStrategy.ITEM_NAME:
                return new AgedBrieStrategy(item);
            case BackstageConcertPassStrategy.ITEM_NAME:
                return new BackstageConcertPassStrategy(item);
            case SulfurasStrategy.ITEM_NAME:
                return new SulfurasStrategy(item);
            default:
                return new DefaultStrategy(item);
        }
    }
}
