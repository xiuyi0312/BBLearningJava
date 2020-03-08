package com.pheobe.objectusage;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MooseYogurtDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // the first input is for price
        double price = scanner.nextFloat();
        MooseYogurt.setPrice(price);

        // the second input is for the number of shops
        int shopCount = scanner.nextInt();
        MooseYogurt[] mooseYogurts = new MooseYogurt[shopCount];
        // initialize all shops
        for (int i = 0; i < shopCount; i++) {
            mooseYogurts[i] = new MooseYogurt();
        }

        // the third input N is for the number of sales
        int saleCount = scanner.nextInt();

        // the next N numbers represent the index of each shop sell yogurt
        for (int i = 0; i < saleCount; i++) {
            int index = scanner.nextInt();
            mooseYogurts[index].sale();
        }

        // output the result
        System.out.println("Frozen Yogurt Sales:");
        System.out.println("Shop Sales Revenue");
        for (int i = 0; i < MooseYogurt.getShopCount(); i++) {
            // each line is for one shop's sale
            System.out.println(mooseYogurts[i].toString());
        }

        System.out.println("Total frozen yogurts sold in all shops: " + MooseYogurt.getSoldCountInAllShops());
        System.out.println("Total revenue from all shops: " + new DecimalFormat("$#0.00").format(MooseYogurt.getSoldCountInAllShops() * MooseYogurt.getPrice()));
        System.out.println("There are " + MooseYogurt.getShopCount() + " Moose Yogurt shops.");
        int topSaleShopIndex = 0;
        for (int i = 1; i < MooseYogurt.getShopCount(); i++) {
            if (mooseYogurts[i].getSoldCount() > mooseYogurts[topSaleShopIndex].getSoldCount()) {
                topSaleShopIndex = i;
            }
        }
        System.out.println("The top shop today is : " + mooseYogurts[topSaleShopIndex].getShopID());
    }
}
