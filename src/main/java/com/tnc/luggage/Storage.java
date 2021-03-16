package com.tnc.luggage;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Storage {
    private Scanner scanner = new Scanner(System.in);

    private Menu menu;
    ArrayList<Slot> slotNumber = new ArrayList<>();

    public void start() {
        Menu menu = new Menu();
        menu.displayMenu();
    }

    public void initiateLuggage() {
        if (slotNumber.size() <= 2) {
            Slot slot = new Slot();
            slot.showSlots();
            System.out.println("\n Choose a slot:");
            var chosenNumber = scanner.nextInt();

            slot.setId(chosenNumber);
            verifyId(chosenNumber);
            slot.setEmpty(true);
            slot.setLuggageSubmission(LocalDateTime.now());
            slotNumber.add(slot);

            isFull(chosenNumber);
//            validateSlot(slot, chosenNumber);
            slot.getChosenSlot(chosenNumber);

            var codeGenerated = generateCode(chosenNumber);

            System.out.println("Your time is: " + " " + LocalTime.now());
            System.out.println("Your code is: " + codeGenerated);
        } else {
            System.out.println("The luggage are full. ");
        }
    }

//    public void validateSlot(Slot slot, int chosenNumber) {
//        for (Slot s : slotNumber) {
//            if (slot.getId() == chosenNumber) {
//                System.out.println("Chose another slot");
//            } else {
//                System.out.println(s);
//            }
//        }
//    }

    public void getOccupiedBox(Slot slot) {
        var occupied = new ArrayList<Slot>();
        occupied.add(slot);
        for (Slot s : occupied) {
            System.out.println(s + " Is occupied.");
        }
    }

    public final Comparator<Slot> isFull = Comparator.comparing(Slot::getId);

    public void verifyId(int chosenNumber) {
        if (slotNumber.contains(isFull)) {
            System.out.println("Slot " + chosenNumber + " is occupied. Please select another slot.");
        }
    }

    ///// resolve verifyId and isFull

    public void isFull(int chosenNumber) {
        Slot slot = new Slot();
        for (Slot s : slotNumber) {
           var i = s.getId();
           if (i == chosenNumber){
               System.out.println("Chose another box.");
           }
        }

    }

    public void payLuggage() {
        Slot slot = new Slot();
        System.out.println("Scan your code: ");
        scanner.nextDouble();
        slot.setTakeLuggage(LocalDateTime.now());
        System.out.println("Your time is: " + LocalTime.now());
        slot.calculatePayTime();
        slot.setEmpty(false);
        System.out.println("You have a total of " + slot.calculatePayTime() + " minutes.");
        setPrice();
        System.out.println("Thank you! ");
        System.out.println(slot.toString());
    }

    public void setPrice() {
        Slot slot = new Slot();
        var time = slot.calculatePayTime();
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
}
