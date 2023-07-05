package com.gildedrose;

public class BackstagePassesUpdate implements QualityUpdate {
    @Override
    public void updateQuality(Item item) {
        if (item.sellIn > 10) {
            increaseItemQuality(item);
        } else if (item.sellIn > 5) {
            increaseItemQuality(item);
            increaseItemQuality(item);
        } else if (item.sellIn > 0) {
            increaseItemQuality(item);
            increaseItemQuality(item);
            increaseItemQuality(item);
        } else {
            item.quality = 0;
        }
        item.sellIn--;
    }

    private void increaseItemQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
