package com.tnc.luggage;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Storage {
    private boolean isOccupied;
    private List<Slot> slotNumber = new ArrayList<>();

}
