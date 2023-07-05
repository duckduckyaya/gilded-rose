package com.gildedrose;

import java.util.Map;

public class QualityUpdateFactory {
    private static final Map<String, QualityUpdate> STRATEGIES = Map.of(
        "Aged Brie", new AgedBrieUpdate(),
        "Sulfuras, Hand of Ragnaros", new SulfurasUpdate(),
        "Backstage passes to a TAFKAL80ETC concert", new BackstagePassesUpdate(),
        "Conjured", new ConjuredUpdate()
    );

    QualityUpdate createStrategy(Item item) {
        return STRATEGIES.getOrDefault(item.name, new NormalUpdate());
    }
}
