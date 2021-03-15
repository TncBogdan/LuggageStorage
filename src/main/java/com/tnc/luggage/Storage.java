package com.tnc.luggage;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage{
    private Menu menu;

    ArrayList<Slot> slotNumber = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        for (int i = 1; i <= 5; i++) {
            Slot slot = new Slot();
            slot.showSlots();
            System.out.println("\n Choose a slot:");
            var chosenNumber = scanner.nextInt();
            validateSlot(slot);
            slot.setId(chosenNumber);
            slot.setEmpty(true);
            slot.setId(chosenNumber);
            slot.getChosenSlot(chosenNumber);
            var codeGenerated = generateCode(chosenNumber);
            slot.setLuggageSubmission(LocalDateTime.now());
            System.out.println("Your time is: " + " " + LocalTime.now());
            System.out.println("Your code is: " + codeGenerated);
            slotNumber.add(slot);
            verifySlot();
        }
    }

    public void validateSlot(Slot slot) {
        for (Slot s : slotNumber){
            if (!slot.isEmpty()) {
                System.out.println("Chose another slot");
            }
                System.out.println(s);
        }
    }

    public void verifySlot() {
        for (Slot s : slotNumber) {
            System.out.println(s);
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
