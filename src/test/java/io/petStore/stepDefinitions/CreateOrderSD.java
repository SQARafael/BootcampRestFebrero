package io.petStore.stepDefinitions;
/*
 * @(#) CreateOrderSD.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.petStore.tasks.order.CreateOrder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static io.petStore.constants.Contants.baseUrl;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class CreateOrderSD {
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

    @When("I sendth e info petID {string} quantity {string} and shipDate {string}")
    public void iSendthEInfoPetIDQuantityAndShipDate(String petID, String quantity, String shipDate) {
        user.attemptsTo(
                CreateOrder.fromOrder(Integer.parseInt(petID),Integer.parseInt(quantity),shipDate)
        );
    }
    @Then("I can validate response server code {int}")
    public void iCanValidateResponseServerCode(Integer int1) {

    }
}
