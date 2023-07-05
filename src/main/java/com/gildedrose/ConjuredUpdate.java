package com.gildedrose;

public class ConjuredUpdate implements QualityUpdate {
    @Override
    public void updateQuality(Item item) {
        decreaseItemQuality(item);
        decreaseItemQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            decreaseItemQuality(item);
            decreaseItemQuality(item);
        }
    }

    private void decreaseItemQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
