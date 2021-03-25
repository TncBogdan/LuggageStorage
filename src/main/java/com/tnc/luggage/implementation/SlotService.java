package com.tnc.luggage.implementation;

import com.tnc.luggage.interfaces.AddObject;
import com.tnc.luggage.interfaces.SetObject;
import com.tnc.luggage.model.Box;
import com.tnc.luggage.model.Slot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SlotService implements AddObject, SetObject {
    private final Slot slot = new Slot();
    private List<Slot> slotArrayList = new ArrayList<>(Collections.nCopies(10, null));

    @Override
    public void addAndSetObject(Slot slot, Box box) {
        slotArrayList.add(slot);
        slotArrayList.set(slot.getId(), slot);
        printSlot();
    }

    public Slot setAndSaveSlotAndStorageBoolean(Slot slot, Integer chosenNumber) {
        var comp = Comparator.comparing(Slot::getId);
        if (!comp.equals(chosenNumber)) {
            slot.setId(chosenNumber -1);
            slot.setLuggageSubmission(LocalDateTime.now());
        } else {
            return null;
        }
        return slot;
    }

    public void printSlot() {
        slotArrayList = slotArrayList.stream().limit(10).collect(Collectors.toList());
        for (Slot s : slotArrayList) {
            System.out.println(s);
        }
    }

    @Override
    public void setObjectToNull(Slot slot) {
        if (slotArrayList != null && slotArrayList.indexOf(slot) == slot.getId()) {
            slotArrayList.remove(slot);
        }
    }

    public Slot getSlotId(double slotCode, LocalDateTime instantNow) {
        Slot s1 = new Slot();
        for (Slot s : slotArrayList) {
            if (s != null && s.getCode() == slotCode) {
                s.setGetLuggage(instantNow);
                return s;
            }
        }
        return s1;
    }

    public long calculatePayTime(Slot slot) {
        return Duration.between(slot.getLuggageSubmission(), slot.getGetLuggage()).toSeconds();
    }

    public long setTotalPay(Slot slot) {
        slot.setPay(calculatePayTime(slot));
        return slot.getPay();
    }
}
