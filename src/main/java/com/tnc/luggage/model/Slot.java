package com.tnc.luggage.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Slot {
    private int id;
    private long pay;
    private double code;
    private LocalDateTime luggageSubmission;
    private LocalDateTime getLuggage;

}
