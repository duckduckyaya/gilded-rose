package com.gildedrose;

public class AgedBrieUpdate implements QualityUpdate {
    @Override
    public void updateQuality(Item item) {
        increaseItemQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            increaseItemQuality(item);
        }
    }

    private void increaseItemQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
