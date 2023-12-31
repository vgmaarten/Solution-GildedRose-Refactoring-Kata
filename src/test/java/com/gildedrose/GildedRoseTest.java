package com.gildedrose;

import com.gildedrose.updatestrategy.AgedBrieStrategy;
import com.gildedrose.updatestrategy.BackstageConcertPassStrategy;
import com.gildedrose.updatestrategy.ConjuredStrategy;
import com.gildedrose.updatestrategy.SulfurasStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private static final String REGULAR_ITEM_1 = "regular item 1";
    private static final String REGULAR_ITEM_2 = "regular item 2";

    @Test
    void regular_item_decrease_sellin_date() {
        Item[] items = new Item[]{new Item(REGULAR_ITEM_1, 2, 3)};
        GildedRose app = new GildedRose(items);

        app.updateInventoryDaily();

        assertEquals(REGULAR_ITEM_1, app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void regular_item_degrading_quality() {
        Item[] items = new Item[]{
            new Item(REGULAR_ITEM_1, 2, 3),
            new Item(REGULAR_ITEM_2, 4, 5),
        };
        GildedRose app = new GildedRose(items);

        app.updateInventoryDaily();

        assertEquals(REGULAR_ITEM_1, app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);

        assertEquals(REGULAR_ITEM_2, app.items[1].name);
        assertEquals(3, app.items[1].sellIn);
        assertEquals(4, app.items[1].quality);
    }

    @Test
    void regular_item_degrades_twice_as_fast_with_passed_sell_date() {
        Item[] items = new Item[]{new Item(REGULAR_ITEM_1, 0, 4)};
        GildedRose app = new GildedRose(items);

        app.updateInventoryDaily();

        assertEquals(2, app.items[0].quality);
    }

    @Test
    void item_quality_is_never_negative() {
        Item[] items = new Item[]{new Item(REGULAR_ITEM_1, 0, 0)};
        GildedRose app = new GildedRose(items);

        app.updateInventoryDaily();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void quality_is_always_max_50() {
        Item[] items = new Item[]{
            new Item(AgedBrieStrategy.ITEM_NAME, 3, 50),
            new Item(BackstageConcertPassStrategy.ITEM_NAME, 3, 50)
        };
        GildedRose app = new GildedRose(items);

        app.updateInventoryDaily();

        assertEquals(AgedBrieStrategy.ITEM_NAME, app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);

        assertEquals(BackstageConcertPassStrategy.ITEM_NAME, app.items[1].name);
        assertEquals(50, app.items[1].quality);
        assertEquals(2, app.items[1].sellIn);
    }

    @Test
    void aged_brie_quality_increases() {
        Item[] items = new Item[]{new Item(AgedBrieStrategy.ITEM_NAME, 3, 0)};
        GildedRose app = new GildedRose(items);

        app.updateInventoryDaily();

        assertEquals(1, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    void sulfuras_never_decreases_in_quality_and_never_has_to_be_sold() {
        Item[] items = new Item[]{new Item(SulfurasStrategy.ITEM_NAME, 3, 80)};
        GildedRose app = new GildedRose(items);

        app.updateInventoryDaily();

        assertEquals(80, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }

    @Test
    void backstage_passes_quality_increases() {
        Item[] items = new Item[]{new Item(BackstageConcertPassStrategy.ITEM_NAME, 15, 30)};
        GildedRose app = new GildedRose(items);

        app.updateInventoryDaily();

        assertEquals(31, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    void backstage_passes_quality_increases_with_2_in_10_days() {
        Item[] items = new Item[]{new Item(BackstageConcertPassStrategy.ITEM_NAME, 10, 30)};
        GildedRose app = new GildedRose(items);

        app.updateInventoryDaily();

        assertEquals(32, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void backstage_passes_quality_increases_with_3_in_5_days() {
        Item[] items = new Item[]{new Item(BackstageConcertPassStrategy.ITEM_NAME, 5, 30)};
        GildedRose app = new GildedRose(items);

        app.updateInventoryDaily();

        assertEquals(33, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void backstage_passes_quality_is_0_after_concert() {
        Item[] items = new Item[]{new Item(BackstageConcertPassStrategy.ITEM_NAME, 0, 30)};
        GildedRose app = new GildedRose(items);

        app.updateInventoryDaily();

        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void conjured_item_degradation_twice_as_fast_() {
        Item[] items = new Item[]{new Item(ConjuredStrategy.ITEM_NAME_PREFIX, 10, 10)};
        GildedRose app = new GildedRose(items);

        app.updateInventoryDaily();

        assertEquals(8, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void conjured_item_degradation_after_expiration() {
        Item[] items = new Item[]{new Item(ConjuredStrategy.ITEM_NAME_PREFIX, 0, 10)};
        GildedRose app = new GildedRose(items);

        app.updateInventoryDaily();

        assertEquals(6, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void conjured_item_degradation_never_negative() {
        Item[] items = new Item[]{new Item(ConjuredStrategy.ITEM_NAME_PREFIX, 4, 0)};
        GildedRose app = new GildedRose(items);

        app.updateInventoryDaily();

        assertEquals(0, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }
}
