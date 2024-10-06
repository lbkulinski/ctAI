package net.lbku.model;

import java.time.Instant;

public record Train(
    int run,

    Line line,

    String destination,

    String station,

    Instant predictionTime,

    Instant arrivalTime,

    boolean due,

    boolean scheduled,

    boolean delayed
) {
}
