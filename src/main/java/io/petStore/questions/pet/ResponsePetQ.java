package io.petStore.questions.pet;
/*
 * @(#) ResponsePetQ.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.petStore.models.pet.PostPetModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class ResponsePetQ implements Question {
    @Override
    public PostPetModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(PostPetModel.class);
    }
}
