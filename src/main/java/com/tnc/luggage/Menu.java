package com.tnc.luggage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    StorageService storageService =  new StorageService();

    public void displayMenu() {
        Integer option = Integer.MAX_VALUE;
        while (option != 0) {
            displayOptions();
            option = readOption();
            executeOption(option);
        }
    }

    public void displayOptions() {
        System.out.println("1 - Press 1 for pay.");
        System.out.println("2 - Press 2 for continue.");
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

    public void executeOption(Integer option) {
        switch (option) {
            case 1:
                storageService.payLuggage();
                break;
            case 2:
                storageService.initiateLuggage();
                break;
        }
    }
}
