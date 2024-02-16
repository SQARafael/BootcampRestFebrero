package io.petStore.tasks.order;
/*
 * @(#) CreateOrder.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.petStore.models.order.OrderModel;
import io.petStore.questions.order.BuildOrder;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class CreateOrder implements Task {
    private final Integer petId;
    private final Integer quantity;
    private final String shipDate;

    public CreateOrder(Integer petId, Integer quantity, String shipDate) {
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        OrderModel body = actor.asksFor(BuildOrder.was(petId, quantity, shipDate));
        actor.attemptsTo(
                Post.to("/store/order").with(
                        req->req
                                .contentType(ContentType.JSON)
                                .body(body)
                )
        );

    }

    public static Performable fromOrder(Integer petId, Integer quantity, String shipDate){
        return  instrumented(CreateOrder.class,petId, quantity, shipDate);
    }
}
