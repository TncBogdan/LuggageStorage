package com.tnc.luggage;

public class Main1 {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();

        Storage storage = new Storage();
        storage.start();

    }
}
