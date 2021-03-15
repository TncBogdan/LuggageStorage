package com.tnc.luggage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Storage storage = new Storage();

    public void displayOptions() {
        System.out.println("1 - Press 1 for pay.");
        System.out.println("2 - Press 2 for continue.");
    }

    public void executePayment(Integer option) {
        switch (option) {
            case 1:
                storage.payLuggage();
                break;
            case 2:
                storage.start();
                break;
        }
    }

    public void displayMenu() {
        Integer option = Integer.MAX_VALUE;
        while (option != 0) {
            displayOptions();
            option = readOption();
            executePayment(option);
        }
    }

    private Integer readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your option is: ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }
}
