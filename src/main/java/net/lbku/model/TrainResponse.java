package net.lbku.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Objects;

public record TrainResponse(@JsonAlias("data") TrainBody body) {
    public TrainResponse {
        Objects.requireNonNull(body);
    }
}
