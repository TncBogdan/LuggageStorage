package com.tnc.luggage;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Storage {
    private Menu menu;

    //persist slot in memory

    List<Slot> slotNumber = new ArrayList<>(Arrays.asList(new Slot[5]));
    private final Slot slot = new Slot();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        submissionLuggage();
    }

    public void submissionLuggage() {
        slot.showSlots();
        System.out.println("\n Choose a slot:");
        var chosenNumber = scanner.nextInt();

        if (slotNumber.contains(chosenNumber)) {
            System.out.println("Choose another slot.");
            submissionLuggage();
        }

        slot.getChosenSlot(chosenNumber);
        var codeGenerated = generateCode(chosenNumber);
        slot.setLuggageSubmission(LocalDateTime.now());
        System.out.println("Your time is: " + " " + LocalTime.now());
        System.out.println("Your code is: " + codeGenerated);
        slotNumber.set(chosenNumber, slot);
        slotNumber.add(slot);
        verifySlot(chosenNumber);
    }

    public void verifySlot(int number) {
        for (Slot s : slotNumber) {
            System.out.println(number + " " + s);
        }
    }

    public void payLuggage() {
        System.out.println("Scan your code: ");
        scanner.nextDouble();
        slot.setTakeLuggage(LocalDateTime.now());
        System.out.println("Your time is: " + LocalTime.now());
        slot.calculatePayTime();
        slot.setEmpty(true);
        System.out.println("You have a total of " + slot.calculatePayTime() + " minutes.");
        setPrice();
        System.out.println("Thank you! ");
        System.out.println(slot.toString());
    }

    public void setPrice() {
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
