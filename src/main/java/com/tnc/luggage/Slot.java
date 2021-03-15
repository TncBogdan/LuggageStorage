package com.tnc.luggage;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;

@Data
public class Slot implements Comparator<Slot> {
    int id = 1;
    private boolean isEmpty;
    private LocalDateTime luggageSubmission;
    private LocalDateTime takeLuggage;

    public void showSlots() {
        for (int i = 1; i <= 5; i++) {
            System.out.print("|" + i + " Open| ");
        }
    }

    public void getChosenSlot(int j) {
        System.out.print("Your slot has number: " + j + " " + "\n");
    }

    public long calculatePayTime() {
        return Duration.between(this.getLuggageSubmission(), this.getTakeLuggage()).toMinutes();
    }


    @Override
    public int compare(Slot o1, Slot o2) {
        return 0;
    }
}
