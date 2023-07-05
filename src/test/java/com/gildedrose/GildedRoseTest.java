package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testAgedBrieQualityIncreases() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void testQualityNeverNegative() {
        Item[] items = new Item[] { new Item("normal item", 0, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testSulfurasNeverDecreases() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(80, app.items[0].quality);
    }

    @Test
    void testBackstagePassesQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(10, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void testConjuredItemQualityDecreasesTwice() {
        Item[] items = new Item[] { new Item("Conjured", 5, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void testNormalItemQualityDecreases() {
        Item[] items = new Item[] { new Item("normal item", 5, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    //edge cases
    @Test
    void testQualityNeverMoreThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testQualityDegradesTwiceAsFastAfterSellBy() {
        Item[] items = new Item[] { new Item("normal item", 0, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
    }

    @Test
    void testConjuredItemsDegradeTwiceAsFast() {
        Item[] items = new Item[] { new Item("Conjured", 3, 6) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].quality);
    }

    @Test
    void testConjuredItemsDegradeFourTimesAsFastAfterSellBy() {
        Item[] items = new Item[] { new Item("Conjured", 0, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(6, app.items[0].quality);
    }

    @Test
    void testBackstagePassesQualityDropToZeroAfterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testBackstagePassesQualityIncreasesBy2When10DaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(12, app.items[0].quality);
    }

    @Test
    void testBackstagePassesQualityIncreasesBy3When5DaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(13, app.items[0].quality);
    }

    @Test
    void agedBrieIncreasesInQualityWhenPastSellIn() {
        Item agedBrie = new Item("Aged Brie", 0, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
        gildedRose.updateQuality();
        assertEquals(12, agedBrie.quality);
    }

    @Test
    void qualityNeverExceedsFifty() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});
        gildedRose.updateQuality();
        assertEquals(50, backstagePasses.quality);
    }

    @Test
    void sulfurasNeverDecreasesInQuality() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});
        gildedRose.updateQuality();
        assertEquals(80, sulfuras.quality);
    }

    @Test
    void conjuredItemsDegradeTwiceAsFast() {
        Item conjuredItem = new Item("Conjured", 10, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{conjuredItem});
        gildedRose.updateQuality();
        assertEquals(18, conjuredItem.quality);
    }

    @Test
    void conjuredItemsDegradeFourTimesAsFastPastSellIn() {
        Item conjuredItem = new Item("Conjured", 0, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{conjuredItem});
        gildedRose.updateQuality();
        assertEquals(16, conjuredItem.quality);
    }

    @Test
    void qualityNeverGoesBelowZero() {
        Item normalItem = new Item("Normal Item", 0, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{normalItem});
        gildedRose.updateQuality();
        assertEquals(0, normalItem.quality);
    }


}
