package com.tnc.luggage;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Slot {
    int id;
    private boolean isEmpty;
    private LocalDateTime luggageSubmission;
    private LocalDateTime getLuggage;

//    public void showSlots() {
//        for (int i = 1; i <= 10; i++) {
//            System.out.print("|" + i + " Open| ");
//        }
//    }
//
////    public void getChosenSlot(int j) {
////        System.out.print("Your slot has number: " + j + " " + "\n");
////    }
//
//    public long calculatePayTime() {
//        return Duration.between(this.getLuggageSubmission(), this.getTakeLuggage()).toMinutes();
//    }
}
