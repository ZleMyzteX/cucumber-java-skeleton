package io.cucumber.shouty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private Person sean;
    private Person lucy;
    private List<String> shoutedMessages = new ArrayList<>();

    @Given("Lucy is located {int} metres from Sean")
    public void lucy_is_located_metres_from_sean(Integer distance) {
        sean = new Person("sean");
        lucy = new Person("lucy");

        lucy.moveTo(distance);
        assertEquals(distance, lucy.getPositionDifference(sean));
    }
    @When("Sean shouts {string}")
    public void sean_shouts(String message) {
        sean.shout(message);
        shoutedMessages.add(message);
    }
    @Then("Lucy hears Sean's message")
    public void lucy_hears_sean_s_message() {
        assertEquals(shoutedMessages, lucy.getMessagesHeard());
    }

    @Then("Lucy didn't hear shouted message")
    public void lucy_didnt_hear_shouted_message() {
        assertEquals(0, lucy.getMessagesHeard().size());
    }
}
