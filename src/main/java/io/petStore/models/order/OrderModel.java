package io.petStore.models.order;
/*
 * @(#) OrderModel.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
@Data
@Builder
public class OrderModel {
    @JsonProperty("id")
    public Long id;
    @JsonProperty("petId")
    public Integer petId;
    @JsonProperty("quantity")
    public Integer quantity;
    @JsonProperty("shipDate")
    public String shipDate;
    @JsonProperty("status")
    public String status;
    @JsonProperty("complete")
    public Boolean complete;
}
