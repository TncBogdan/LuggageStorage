package com.tnc.luggage.implementation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    LuggageImpl luggage = new LuggageImpl();

    public void displayMenu() {
        Integer option = Integer.MAX_VALUE;
        while (option != 0) {
            displayOptions();
            option = readOption();
            executeOption(option);
        }
    }

    private Integer readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select an option: ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    public void displayOptions() {
        System.out.println("1 - Press 1 for pay.");
        System.out.println("2 - Press 2 for continue.");
    }

    public void executeOption(Integer option) {
        switch (option) {
            case 1:
                luggage.payLuggage();
                break;
            case 2:
                luggage.initializeLuggage();
                break;
        }
    }
}
