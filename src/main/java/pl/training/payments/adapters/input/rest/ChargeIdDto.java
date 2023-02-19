package pl.training.payments.adapters.input.rest;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChargeIdDto implements Serializable {

    private String value;

}
