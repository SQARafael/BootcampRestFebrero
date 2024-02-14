package io.petStore.stepDefinitions;
/*
 * @(#) CreatePetStepDef.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.petStore.questions.pet.ResponsePetQ;
import io.petStore.tasks.pet.CreatePet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static io.petStore.constants.Contants.baseUrl;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class CreatePetStepDef {
    private String restBaseUrl;
    private EnvironmentVariables environmentVariables;
    private Actor user;

    @Before
    public void setUpBaseUrl(){
        restBaseUrl= environmentVariables.optionalProperty("restapi.baseurl")
                .orElse(baseUrl);
        user=Actor.named("User final").whoCan(
                CallAnApi.at(restBaseUrl)
        );
    }
    @When("I consume the endpoint {string} and I send the user information id {string}, nameCategory {string} namePet {string}")
    public void sendInfo(String endPoint, String id, String nameCategory, String namePet) {
        user.attemptsTo(
                CreatePet.create(endPoint,id,nameCategory,namePet)
        );
    }
    @Then("I can validate the response service {int}")
    public void validateCode(Integer int1) {

        user.should(
                seeThat(
                        "The status pet is", res-> new ResponsePetQ()
                                .answeredBy(user)
                                .getTags().get(0).getName(),
                        equalTo("peluditos")
                )
        );

    }
}
