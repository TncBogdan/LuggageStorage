package com.tnc.luggage.implementation;

import lombok.Data;

@Data
public class StorageService {

//    private Scanner scanner = new Scanner(System.in);
//    private Box box = new Box();
    //    private Slot slot = new Slot();
//    private List<Slot> slotArrayList = new ArrayList<>(Collections.nCopies(5, null));
//    private List<Box> boxList = new ArrayList<>(Collections.nCopies(5, null));

//    public Slot initializeLuggage() {
//        Slot slot = new Slot();
//        System.out.println("\n Choose a box:");
//        showBoxes();
//        var chosenNumber = scanner.nextInt();
//        addSlot(setAndSaveSlotAndStorageBool(slot, chosenNumber));
//        addSlot(slot, box);
//        var codeGenerated = generateCode(chosenNumber);
//        slot.setCode(codeGenerated);
//        System.out.println("Your time is: " + " " + LocalTime.now());
//        System.out.println("Your code is: " + codeGenerated);
//        return slot;
//    }

//    public void payLuggage() {
//        var instantNow = LocalDateTime.now();
//        System.out.println("Scan your code: ");
//        var slotCode = scanner.nextDouble();
//        System.out.println("Your time is: " + instantNow);
//        var slot = getSlotId(slotCode, instantNow);
//        System.out.println("You have " + setTotalPay(slot) + " minutes.");
//        setPrice(setTotalPay(slot));
//        System.out.println("Thank you! ");
//        System.out.println(slot.toString());
//        setNullSlot(slot);
//        setNullBox(slot);
//    }

    //interfata functionala
    //moved to slotService
//    public void addSlot(Slot slot) {
//        slotArrayList.add(slot);
//        slotArrayList.set(slot.getId(), slot);
//        printSlot();
//    }
    //moved to slotService
//    public Slot setAndSaveSlotAndStorageBool(Slot slot, Integer chosenNumber) {
//        var comp = Comparator.comparing(Slot::getId);
//        if (!comp.equals(chosenNumber)) {
//            slot.setId(chosenNumber);
//            slot.setLuggageSubmission(LocalDateTime.now());
//        } else {
//            return null;
//        }
//        return slot;
//    }
//
//    public void printSlot() {
//        slotArrayList = slotArrayList.stream().limit(5).collect(Collectors.toList());
//        for (Slot s : slotArrayList) {
//            System.out.println(s);
//        }
//    }
//    public void setNullSlot(Slot slot) {
//        if (slotArrayList != null && slotArrayList.indexOf(slot) == slot.getId()) {
//            slotArrayList.remove(slot);
//        }
//    }
//    public Slot getSlotId(double slotCode, LocalDateTime instantNow) {
//        Slot s1 = new Slot();
//        for (Slot s : slotArrayList) {
//            if (s != null && s.getCode() == slotCode) {
//                s.setGetLuggage(instantNow);
//                return s;
//            }
//        }
//        return s1;
//    }
//    public void showBoxes() {
//        boxList = boxList.stream().limit(5).collect(Collectors.toList());
//        for (Box b : boxList) {
//            if (b == null) {
//                System.out.print(" Box ");
//            } else {
//                System.out.print(" X ");
//            }
//        }
//    }

//    public void setNullBox(Slot slot) {
//        if (boxList != null && boxList.indexOf(box) == slot.getId()) {
//            boxList.set(slot.getId(), null);
//        }
//    }

//    public void addSlot(Slot slot, Box box) {
//        box.setId(slot.getId());
//        box.setOccupied(true);
//        boxList.add(box);
//        boxList.set(slot.getId(), box);
//    }

//    public void setPrice(long calc) {
//        var price = 10;
//        if (calc <= 60) {
//            System.out.println(price + " lei");
//        } else if (calc <= 120) {
//            System.out.println((price += 5) + " lei");
//        } else if (calc <= 180) {
//            System.out.println((price += 10) + " lei");
//        } else if (calc <= 240) {
//            System.out.println((price += 15) + " lei");
//        } else {
//            System.out.println("50 lei");
//        }
//    }
//
//    public static double generateCode(double number) {
//        return number + (Math.floor(Math.random() * 9_000_000) + 1_000_000);
//    }

    /// to slotService
//    public long calculatePayTime(Slot slot) {
//        return Duration.between(slot.getLuggageSubmission(), slot.getGetLuggage()).toSeconds();
//    }
//
//    public long setTotalPay(Slot slot) {
//        slot.setPay(calculatePayTime(slot));
//        return slot.getPay();
//    }
}
