package com.tnc.luggage;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Data
public class StorageService {

    private Scanner scanner = new Scanner(System.in);
    private Box box = new Box();
    private Slot slot = new Slot();
    private List<Slot> slotArrayList = new ArrayList<>(Collections.nCopies(5, null));
    private List<Box> boxList = new ArrayList<>(Collections.nCopies(5, null));

    public void start() {
        Menu menu = new Menu();
        menu.displayMenu();
    }

    public void initiateLuggage() {
        if (!(slotArrayList == null)) {

            showBoxes();
            Slot slot = new Slot();
            System.out.println("\n Choose a box:");
            var chosenNumber = scanner.nextInt();
            addSlot(setAndSaveSlotAndStorageBool(slot, chosenNumber), box);

//            var codeGenerated = generateCode(chosenNumber);
//            System.out.println("Your time is: " + " " + LocalTime.now());
//            System.out.println("Your code is: " + codeGenerated);
        } else {
            System.out.println("The luggage are full. ");
        }
    }

    public void addSlot(Slot slot, Box box) {
        slotArrayList.add(slot);
        slotArrayList.set(slot.getId(), slot);
        printSlot();
        box.setId(slot.getId());
        box.setOccupied(true);
        boxList.add(box);
        boxList.set(slot.getId(), box);
    }

    public Slot setAndSaveSlotAndStorageBool(Slot slot, Integer chosenNumber) {
        var comp = Comparator.comparing(Slot::getId);

//        if (slot.getId() != chosenNumber) {
        if (!comp.equals(chosenNumber)) {
            slot.setId(chosenNumber);
            slot.setLuggageSubmission(LocalDateTime.now());
        } else {
            return null;
        }
        return slot;
    }

    public void printSlot() {
        slotArrayList = slotArrayList.stream().limit(5).collect(Collectors.toList());
        for (Slot s : slotArrayList) {
            System.out.println(s);
        }
    }
///////////////// verify boxId =! null
    public void showBoxes() {
        boxList = boxList.stream().limit(5).collect(Collectors.toList());
        for (Box b : boxList) {
            if (box.getId() = null) {
                System.out.print(" Box " + box.getId());
            } else {
                System.out.print("Null");
            }
        }
    }

//    public void showBoxes(Slot slot) {
//        for (int i = slotArrayList.size(); i < 5; i++) {
//            if (slotArrayList.size()< 5) {
//                slotArrayList.add(slot);
//            }else {
//                System.out.println("Luggage is full");
//            }
//        }
//    }

    public void payLuggage() {
        Slot slot = new Slot();
        System.out.println("Scan your code: ");
        scanner.nextDouble();
        slot.setGetLuggage(LocalDateTime.now());
        System.out.println("Your time is: " + LocalTime.now());
        calculatePayTime();
//        box.isOccupied = false;
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
