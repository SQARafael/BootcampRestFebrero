package io.petStore.questions.order;
/*
 * @(#) BuildOrder.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.petStore.models.order.OrderModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class BuildOrder implements Question<OrderModel> {
    private final Integer petId;
    private final Integer quantity;
    private final String shipDate;

    public BuildOrder(Integer petId, Integer quantity, String shipDate) {
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
    }

    @Override
    public OrderModel answeredBy(Actor actor) {
        return OrderModel.builder()
                .id(Long.parseLong("450"))
                .petId(petId)
                .quantity(quantity)
                .shipDate(shipDate)
                .status("placed")
                .complete(true)
                .build();
    }

    public static BuildOrder was(Integer petId, Integer quantity, String shipDate){

        return new BuildOrder(petId, quantity, shipDate);

    }
}
