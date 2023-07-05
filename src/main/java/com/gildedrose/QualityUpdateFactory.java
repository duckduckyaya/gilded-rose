package com.gildedrose;

public class QualityUpdateFactory {
    QualityUpdate createStrategy(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieUpdate();
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasUpdate();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassesUpdate();
            case "Conjured":
                return new ConjuredUpdate();
            default:
                return new NormalUpdate();
        }
    }
}
