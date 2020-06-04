package com.virgingames.steps;

/*
Created by SP
*/

import com.virgingames.constants.EndPoints;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class VirginGamesSteps {

    /*
     * Defining the steps, and method for getting all the Games information
     * And parsing the text/plain into Json format
     */

    @Step("Getting the information of all the Games")
    public ValidatableResponse getGamesInfo() {

        return SerenityRest.rest()
                .given()
                .log()
                .all()
                .when()
                .get(EndPoints.GET_ALL_BINGO)
                .then().log().ifValidationFails()
                .parser("text/plain", Parser.JSON);
    }

}
