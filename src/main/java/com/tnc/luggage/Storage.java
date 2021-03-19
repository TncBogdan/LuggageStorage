package com.tnc.luggage;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;

public class Storage {
    private Scanner scanner = new Scanner(System.in);

    List<Slot> slotNumber = new ArrayList<>();

    public void start() {
        Menu menu = new Menu();
        menu.displayMenu();
    }

    public synchronized void initiateLuggage() {
        if (slotNumber.size() <= 3) {
            Slot slot = new Slot();
            slot.showSlots();
            System.out.println("\n Choose a slot:");
            var chosenNumber = scanner.nextInt();
            getOccupiedBox(chosenNumber, slot);
            slot.setId(chosenNumber);

            slot.setEmpty(true);
            slot.setLuggageSubmission(LocalDateTime.now());
            slotNumber.add(slot);
            printSlot();

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
        for (Slot s : slotNumber) {
            System.out.println(s);
        }
    }

    public void getOccupiedBox(Integer number, Slot slot) {
        try
        {
        for (Slot s : slotNumber) {
            if (s.getId() == (number.byteValue())) {
                System.out.println("Choose another slot.");
                initiateLuggage();
            }
        }
        }catch (ConcurrentModificationException e){
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
