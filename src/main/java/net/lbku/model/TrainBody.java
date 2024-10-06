package net.lbku.model;

import java.util.List;
import java.util.Objects;

public record TrainBody(List<Train> trains) {
    public TrainBody {
        Objects.requireNonNull(trains);
    }
}
