package com.tnc.luggage;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class Slot {
    private boolean isEmpty;
    private LocalDateTime luggageSubmission;
    private LocalDateTime takeLuggage;

    public void showSlots() {
        for (int i = 1; i <= 20; i++) {
            System.out.print("|" + i + " Open| ");
        }
    }

    public void getChosenSlot(int j) {
        System.out.print("Your slot has number: " + j + " " + "\n");
    }

    public long calculatePayTime() {
        return Duration.between(this.getLuggageSubmission(), this.getTakeLuggage()).toMinutes();
    }
}
