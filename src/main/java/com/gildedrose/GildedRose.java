package com.gildedrose;
public class GildedRose {
    Item[] items;
    QualityUpdateFactory strategyFactory = new QualityUpdateFactory();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            QualityUpdate strategy = strategyFactory.createStrategy(item);
            strategy.updateQuality(item);
        }
    }

}
