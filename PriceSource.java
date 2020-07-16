package service;

import service.PriceListener;

public interface PriceSource {
    void addPriceListener(PriceListener listener);
    void removePriceListener(PriceListener listener);
}
