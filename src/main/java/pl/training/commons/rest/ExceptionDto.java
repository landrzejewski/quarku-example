package pl.training.commons.rest;

import lombok.Value;

import java.time.Instant;

@Value
public class ExceptionDto {

    Instant timestamp;
    String description;

}
