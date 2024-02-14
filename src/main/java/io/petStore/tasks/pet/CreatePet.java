package io.petStore.tasks.pet;
/*
 * @(#) CreatePet.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.petStore.models.pet.PostPetModel;
import io.petStore.questions.pet.BuildPetQ;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class CreatePet implements Task {
    private final  String endPoint;
    private final  String id;
    private final  String nameCategory;
    private  final  String namePet;

    public CreatePet(String endPoint, String id, String nameCategory, String namePet) {
        this.endPoint = endPoint;
        this.id = id;
        this.nameCategory = nameCategory;
        this.namePet = namePet;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        PostPetModel bodyPet = actor.asksFor(BuildPetQ.was(id, nameCategory, namePet));

        actor.attemptsTo(
                Post.to(endPoint).with(
                        req->req
                                .contentType(ContentType.JSON)
                                .body(bodyPet)
                )
        );

    }

    public  static CreatePet create(String endPoint, String id, String nameCategory, String namePet){
        return instrumented(CreatePet.class,endPoint,id,nameCategory,namePet);
    }
}
