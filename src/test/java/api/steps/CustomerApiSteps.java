package api.steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class CustomerApiSteps {

    private Response response;
    private String userId;

    private final String APP_ID = "63a804408eb0cb069b57e43a";

    @Given("user set base api url")
    public void setBaseUrl() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
    }

    @When("user create new user")
    public void createUser() {

        String email = "user" + System.currentTimeMillis() + "@mail.com";

        response = given()
                .header("app-id", APP_ID)
                .contentType(ContentType.JSON)
                .body("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"" + email + "\"}")
                .post("/user/create"); // FIXED ENDPOINT

        System.out.println("\n==============================");
        System.out.println("=== CREATE USER DEBUG ===");
        System.out.println("STATUS : " + response.getStatusCode());
        System.out.println("BODY   : " + response.asString());
        System.out.println("==============================\n");

        assertTrue("CREATE USER FAILED → " + response.asString(),
                response.getStatusCode() < 400);

        userId = response.jsonPath().getString("id");
        assertNotNull("USER ID IS NULL", userId);

        System.out.println("USER ID: " + userId);
    }

    @When("user get user by id")
    public void getUser() {

        response = given()
                .header("app-id", APP_ID)
                .get("/user/" + userId);

        System.out.println("=== GET USER ===");
        System.out.println(response.asString());

        assertTrue(response.getStatusCode() < 400);
    }

    @When("user update user")
    public void updateUser() {

        response = given()
                .header("app-id", APP_ID)
                .contentType(ContentType.JSON)
                .body("{\"firstName\":\"Updated\"}")
                .put("/user/" + userId);

        System.out.println("=== UPDATE USER ===");
        System.out.println(response.asString());

        assertTrue(response.getStatusCode() < 400);
    }

    @When("user delete user")
    public void deleteUser() {

        response = given()
                .header("app-id", APP_ID)
                .delete("/user/" + userId);

        System.out.println("=== DELETE USER ===");
        System.out.println(response.asString());

        assertTrue(response.getStatusCode() < 400);
    }

    @Then("response should be success")
    public void verifySuccess() {

        int code = response.getStatusCode();

        System.out.println("STATUS: " + code);
        System.out.println("BODY: " + response.asString());

        assertTrue("Expected success but got " + code,
                code == 200 || code == 201 || code == 204);
    }
}