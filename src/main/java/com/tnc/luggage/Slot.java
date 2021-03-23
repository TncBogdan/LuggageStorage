package com.tnc.luggage;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Slot {
    int id;
    private LocalDateTime luggageSubmission;
    private LocalDateTime getLuggage;

}
