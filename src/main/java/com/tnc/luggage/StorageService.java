package com.tnc.luggage;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

@Data
public class StorageService {

    private Scanner scanner = new Scanner(System.in);
    private Slot slot = new Slot();
    private ArrayList<Slot> slotArrayList = new ArrayList<>();

    public void start() {
        Menu menu = new Menu();
        menu.displayMenu();
    }
    public void initiateLuggage() {
/////////////// add arrayList<Boxes> and replace this slotArrayList
//        boolean isOccupied and id
        if (slotArrayList.size() != 0) {
            Slot slot = new Slot();
            showFreeBoxes();
            System.out.println("\n Choose a box:");
            var chosenNumber = scanner.nextInt();
            addSlot(setAndSaveSlotAndStorageBool(slot, chosenNumber));

            var codeGenerated = generateCode(chosenNumber);
//            System.out.println("Your time is: " + " " + LocalTime.now());
//            System.out.println("Your code is: " + codeGenerated);
        } else {
            System.out.println("The luggage are full. ");
        }
    }

    public Slot setAndSaveSlotAndStorageBool(Slot slot, int chosenNumber) {
        slot.setId(chosenNumber);
        slot.setEmpty(true);
        slot.setLuggageSubmission(LocalDateTime.now());
        return slot;
    }

    public Slot addSlot(Slot slot) {
        if (slot.isEmpty()) {
            slotArrayList.add(slot);
            slotArrayList.set(slot.getId(), slot);
            printSlot();
        }
        return slot;
    }

    public void printSlot() {
        for (Slot s : slotArrayList) {
            System.out.println(s);
        }
    }

    ////////////////////////////// this method must expose only the free boxes
    public void showFreeBoxes() {
        for (int i = slotArrayList.size(); i < 5; i++) {
//        for (int i = 1; i <= slotArrayList.size();  i++) {
            slotArrayList.add(i, slot);
//            slotArrayList.set(i, slot);
            if (slotArrayList.contains(slot)) {
                System.out.print(" Box " + i);
            }
        }
    }
////////////////////////////////

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

    public long calculatePayTime() {
        return Duration.between(slot.getLuggageSubmission(), slot.getGetLuggage()).toMinutes();
    }
}
