package net.lbku.service;

import net.lbku.model.Train;

import java.util.List;
import java.util.Objects;

public record Response(List<Train> trains) {
    public Response {
        Objects.requireNonNull(trains);

        trains = List.copyOf(trains);
    }
}
