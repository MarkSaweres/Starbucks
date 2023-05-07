package com.example.springstarbucksclient.model;

import java.util.Random;
import lombok.Data;

@Data
public class CashierOrder {
    private String drink;
    private String milk;
    private String size;
    private String total;
    private String register;
    private String status;
    private String store;

    public static CashierOrder GetNewOrder() {
        String[] DRINK_OPTIONS = { "Caffe Latte", "Caffe Americano", "Caffe Mocha", "Espresso", "Cappuccino" };
        String[] MILK_OPTIONS = { "Whole Milk", "2% Milk", "Nonfat Milk", "Almond Milk", "Soy Milk" };
        String[] NON_ESPRESSO_SIZE_OPTIONS = { "Tall", "Grande", "Venti" };
        String[] ESPRESSO_SIZE_OPTIONS = { "Short", "Tall" };

        Random random = new Random();

        String randomDrink = DRINK_OPTIONS[random.nextInt(DRINK_OPTIONS.length)];
        String randomMilk = MILK_OPTIONS[random.nextInt(MILK_OPTIONS.length)];
        String randomSize;
        if(randomDrink.equals("Espresso")) {
            randomSize = ESPRESSO_SIZE_OPTIONS[random.nextInt(ESPRESSO_SIZE_OPTIONS.length)];
        } else {
            randomSize = NON_ESPRESSO_SIZE_OPTIONS[random.nextInt(NON_ESPRESSO_SIZE_OPTIONS.length)];
        }

        CashierOrder cashierOrder = new CashierOrder();
        cashierOrder.setDrink(randomDrink);
        cashierOrder.setMilk(randomMilk);
        cashierOrder.setSize(randomSize);
        cashierOrder.setStatus("New");

        return cashierOrder;
    }
}


/*

https://priceqube.com/menu-prices/%E2%98%95-starbucks

var DRINK_OPTIONS = [ "Caffe Latte", "Caffe Americano", "Caffe Mocha", "Espresso", "Cappuccino" ];
var MILK_OPTIONS  = [ "Whole Milk", "2% Milk", "Nonfat Milk", "Almond Milk", "Soy Milk" ];
var SIZE_OPTIONS  = [ "Short", "Tall", "Grande", "Venti", "Your Own Cup" ];

Caffè Latte
=============
tall 	$2.95
grande 	$3.65
venti 	$3.95 (Your Own Cup)

Caffè Americano
===============
tall 	$2.25
grande 	$2.65
venti 	$2.95 (Your Own Cup)

Caffè Mocha
=============
tall 	$3.45
grande 	$4.15
venti 	$4.45 (Your Own Cup)

Cappuccino
==========
tall 	$2.95
grande 	$3.65
venti 	$3.95 (Your Own Cup)

Espresso
========
short 	$1.75
tall 	$1.95

 */



