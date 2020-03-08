package com.pheobe.objectusage;

import java.text.DecimalFormat;

public class MooseYogurt {
    private String shopID;
    private int soldCount;
    private static int shopCount = 0;
    private static int soldCountInAllShops = 0;
    private static double price;

    public MooseYogurt() {
        this.shopID = "M" + (++shopCount);// add then concat
        this.soldCount = 0;
    }

    public void sale() {
        soldCount++;
        soldCountInAllShops ++;
    }

    /**
     * @return the number of frozen yogurt in this shop
     */
    public int getSoldCount() {
        return soldCount;
    }

    public String getShopID() {
        return shopID;
    }

    public static void setPrice(double p) {
        price = p;
    }

    public static double getPrice() {
        return price;
    }

    public static int getSoldCountInAllShops() {
        return soldCountInAllShops;
    }

    public static int getShopCount() {
        return shopCount;
    }

    @Override
    public String toString() {
        String revenue = new DecimalFormat("$#0.00").format(soldCount * price);
        return String.format("%s%6d%10s", shopID, soldCount, revenue);
    }
}
