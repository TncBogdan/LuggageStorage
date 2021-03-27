package com.tnc.luggage.implementation;

import com.tnc.luggage.model.Slot;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class LuggageImpl {
    private final Scanner scanner = new Scanner(System.in);
    private final BoxService boxService = new BoxService();
    private final SlotService slotService = new SlotService();

    public Slot initializeLuggage() {
        Slot slot = new Slot();
        System.out.println("\n Choose a box:");
        boxService.showBoxes();
        var chosenNumber = scanner.nextInt();
        var generateCode = slotService.generateCode(chosenNumber);
        slot.setCode(generateCode);
        slotService.setAndSaveSlotAndStorageBoolean(slot, chosenNumber);
        slotService.addAndSetObject(slot, boxService.box);
        boxService.addAndSetObject(slot, boxService.box);
        System.out.println("Your time is: " + " " + LocalTime.now());
        System.out.println("Your code is: " + generateCode);
        return slot;
    }

    public void payLuggage() {
        var instantNow = LocalDateTime.now();
        System.out.println("Scan your code: ");
        var slotCode = scanner.nextDouble();
        System.out.println("Your time is: " + instantNow);
        var slot = slotService.getSlotId(slotCode, instantNow);
        System.out.println("You have " + slotService.calculatePayTime(slot) + " minutes.");
        slotService.setTotalPay(slot);
        System.out.println("Thank you! ");
        System.out.println(slot.toString());
        slotService.setObjectToNull(slot);
        boxService.setObjectToNull(slot);
    }
}
