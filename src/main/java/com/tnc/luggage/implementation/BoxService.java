package com.tnc.luggage.implementation;

import com.tnc.luggage.interfaces.AddAndSetObject;
import com.tnc.luggage.model.Box;
import com.tnc.luggage.model.Slot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BoxService implements AddAndSetObject {
    Box box = new Box();
    List<Box> boxList = new ArrayList<>(Collections.nCopies(10, null));

    @Override
    public void addAndSetObject(Slot slot, Box box) {
        box.setId(slot.getId());
        box.setOccupied(true);
        boxList.add(box);
        boxList.set(slot.getId(), box);
    }

    @Override
    public void setObjectToNull(Slot slot) {
        if (boxList != null && boxList.indexOf(box) == slot.getId()) {
            boxList.set(slot.getId(), null);
        }
    }

    public void showBoxes() {
        boxList = boxList.stream().limit(10).collect(Collectors.toList());
        int count = 1;
        for (Box b : boxList) {
            if (b == null) {
                System.out.print("|" + " Box " + count + "|");
            } else {
                System.out.print(" X ");
            }
                count++;
        }
    }
}