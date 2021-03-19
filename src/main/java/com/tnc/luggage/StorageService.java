package com.tnc.luggage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class StorageService {

    private Menu menu = new Menu();
    private Scanner scanner = new Scanner(System.in);
    private Slot slot = new Slot();
    private Storage storage = new Storage();

    public void start() {
        Menu menu = new Menu();
        menu.displayMenu();
    }

    public void setAndSaveSlotAndStorageBool(Slot slot, int chosenNumber) {
        slot.setId(chosenNumber);
        slot.setEmpty(true);
        slot.setLuggageSubmission(LocalDateTime.now());
        storage.setOccupied(true);
        storage.getSlotNumber().add(slot);
        printSlot();
    }

    public void initiateLuggage() {
        if (storage.getSlotNumber().size() <= 3) {
            menu.displayOptions();
            Slot slot = new Slot();
            showSlots();
            System.out.println("\n Choose a slot:");
            var chosenNumber = scanner.nextInt();
            getOccupiedBox(chosenNumber, slot);

            setAndSaveSlotAndStorageBool(slot, chosenNumber);

//            slot.setId(chosenNumber);
//            slot.setEmpty(true);
//            slot.setLuggageSubmission(LocalDateTime.now());
//            storage.getSlotNumber().add(slot);
//            printSlot();

            var codeGenerated = generateCode(chosenNumber);
//            System.out.println("Your time is: " + " " + LocalTime.now());
//            System.out.println("Your code is: " + codeGenerated);
            try {
                initiateLuggage();
            } catch (StackOverflowError e) {
                System.out.println("FULL");
            }
        } else {
            System.out.println("The luggage are full. ");
        }
    }


    public void printSlot() {
        for (Slot s : storage.getSlotNumber()) {
            System.out.println(s);
        }
    }

    public void getOccupiedBox(Integer number, Slot slot) {
        try {
            for (Slot s : storage.getSlotNumber()) {
                if (s.getId() == (number.byteValue())) {
                    System.out.println("Choose another slot.");
                    initiateLuggage();
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("BUG");
        }
    }


//    persons.stream()
//            .filter( p-> p.getSurname().equals(“Mellor”) )
//            .collect( toList() );

    public void payLuggage() {
        Slot slot = new Slot();
        System.out.println("Scan your code: ");
        scanner.nextDouble();
        slot.setGetLuggage(LocalDateTime.now());
        System.out.println("Your time is: " + LocalTime.now());
        calculatePayTime();
        slot.setEmpty(false);
        System.out.println("You have a total of " + calculatePayTime() + " minutes.");
        setPrice();
        System.out.println("Thank you! ");
        System.out.println(slot.toString());
    }

    public void setPrice() {
        Slot slot = new Slot();
        var time = calculatePayTime();
        var price = 10;
        if (time <= 60) {
            System.out.println(price);
        } else if (time <= 120) {
            System.out.println(price += 5);
        } else if (time <= 180) {
            System.out.println(price += 10);
        } else if (time <= 240) {
            System.out.println(price += 15);
        } else {
            System.out.println("50 lei");
        }
    }

    public static double generateCode(double number) {
        return number + (Math.floor(Math.random() * 9_000_000) + 1_000_000);
    }

    public void showSlots() {
        for (int i = 1; i <= 10; i++) {
            System.out.print("|" + i + " Open| ");
        }
    }

//    public void getChosenSlot(int j) {
//        System.out.print("Your slot has number: " + j + " " + "\n");
//    }

    public long calculatePayTime() {
        return Duration.between(slot.getLuggageSubmission(), slot.getGetLuggage()).toMinutes();
    }
}
