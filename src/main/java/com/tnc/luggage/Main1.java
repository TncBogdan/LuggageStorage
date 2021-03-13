package com.tnc.luggage;

public class Main1 {

    public static void main(String[] args) {
        Storage storage = new Storage();
        storage.start();

        Menu menu = new Menu();
        menu.displayMenu();
    }
}
