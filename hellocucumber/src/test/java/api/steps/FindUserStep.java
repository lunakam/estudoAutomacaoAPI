package api.steps;

import api.serviceObject.FindUser;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FindUserStep {
   private FindUser userService = new FindUser();

    @Given("^I have a valid request$")
    public void i_have_a_valid_request() {
        userService.getValidRequest();
    }

    @When("^I search a user$")
    public void i_search_a_user() {
        userService.search();
    }

    @Then("^I should see the user data$")
    public void i_should_see_the_user_data() {
        userService.validateResponse();
    }

    @When("^I search an invalid user$")
    public void iSearchAnInvalidUser() {
        userService.searchInvalid();
    }

    @Then("^I should see status code (.+)$")
    public void iShouldSeeStatusCode(int statusCode) {
        userService.validateStatusCode(statusCode);
    }

    @When("^I search an delay request$")
    public void iSearchAnDelayRequest() {
        userService.searchDelay();
    }

    @And("^I should see the time response delay$")
    public void iShouldSeeTheTimeResponseDelay() {
        userService.validateTimeResponse();
    }

    @When("^I create a new user$")
    public void iCreateANewUser() {
        userService.postUser();
    }
}
