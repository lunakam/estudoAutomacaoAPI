package api.serviceObject;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.lessThan;

public class FindUser {
    private RequestSpecification request;
    private Response response;


    public void getValidRequest() {
        request = request.given()
                .baseUri("https://reqres.in/")
                .basePath("/api")
                .contentType(ContentType.JSON);
    }

    public void search() {
        response = request.when()
                .get("/users/2")
                .andReturn();
    }

    public void searchInvalid() {
        response = request.when()
                .get("/users/23")
                .andReturn();
    }

    public void searchDelay() {
        response = request.when()
                .get("/users?delay=3")
                .andReturn();
    }

    public void validateResponse() {
        response.then()
                .assertThat().statusCode(200)
                .body("id", Matchers.is(2))
                .body("first_name", Matchers.is("Janet"))
                .body("last_name", Matchers.is("Weaver"))
                .body("avatar", Matchers.is("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"));
    }

    public void validateStatusCode(int statusCode) {
        response.then()
                .assertThat().statusCode(statusCode);
    }

    public void validateTimeResponse() {
        response.then()
                .assertThat().time(lessThan(10l));
    }

    public void postUser() {
        response = request.when()
                .get("/api/users")
                .andReturn();

    }
}
