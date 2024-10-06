package net.lbku.service;

public record Request(int stationId) {
    public Request {
        if (stationId < 0) {
            throw new IllegalArgumentException("the specified station ID must be greater than or equal to 0");
        }
    }
}
