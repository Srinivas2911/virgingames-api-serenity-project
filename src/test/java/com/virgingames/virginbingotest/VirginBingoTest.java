package com.virgingames.virginbingotest;

/*
Created by SP
*/

import com.virgingames.steps.VirginGamesSteps;
import com.virgingames.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SerenityRunner.class)
public class VirginBingoTest extends TestBase {


    static String defaultGameFrequency;
    static String timeStamp;
    static String startTime;

    @Steps
    VirginGamesSteps virginSteps;

    /*
     * This test will verify that all Games extracted has
     * defaultGameFrequency = 300000.
     */

    @Title("Verifying That All the Games Contains Only DefaultGameFrequency=300000")
    @Test
    public void test001() {
        ValidatableResponse response = virginSteps.getGamesInfo()
                .statusCode(200);
        defaultGameFrequency = response.extract().body().path("bingoLobbyInfoResource.streams.findAll{it.defaultGameFrequency='300000'}").toString();

        Assert.assertTrue(defaultGameFrequency.contains("defaultGameFrequency=300000"));
        Assert.assertFalse(defaultGameFrequency.contains("defaultGameFrequency=null"));
        System.out.println("The Games with the defaultGameFrequency=300000 are : " + defaultGameFrequency);
    }

    /*
     * This test will also verify that all defaultGameFrequency = 300000.
     */

    @Title("Verifying That the value of defaultGameFrequency=300000")
    @Test
    public void test002() {
        ValidatableResponse response = virginSteps.getGamesInfo()
                .statusCode(200);
        defaultGameFrequency = response.extract().body().path("bingoLobbyInfoResource.streams.findAll{it.defaultGameFrequency='300000'}.defaultGameFrequency").toString();

        Assert.assertTrue(defaultGameFrequency.contains("300000"));
        Assert.assertFalse(defaultGameFrequency.contains("null"));
        System.out.println("The defaultGameFrequency values are : " + defaultGameFrequency);
    }

    /*
     * This test will verify that the startTime for all Games is always future timestamp.
     * i.e. startTimes are greater than timeStamp.
     */


    @Title("Verifying That the startTime is always future timeStamp")
    @Test
    public void test003() {

        ValidatableResponse response = virginSteps.getGamesInfo()
                .statusCode(200);
        timeStamp = response.extract().path("timestamp").toString();
        startTime = response.extract().path("bingoLobbyInfoResource.streams.startTime").toString();

        assertThat(startTime, greaterThan(timeStamp));

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The timestamp is : " + timeStamp);
        System.out.println("The startTimes are :" + startTime);
        System.out.println("------------------End of Test---------------------------");
    }

}
