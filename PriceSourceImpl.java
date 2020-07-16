package service;

import service.PriceListener;
import service.PriceSource;

public class PriceSourceImpl implements PriceSource {
    public void addPriceListener(PriceListener listener) {
        listener.priceUpdate("DBUSER",10);

    }

    public void removePriceListener(PriceListener listener) {

    }
}
