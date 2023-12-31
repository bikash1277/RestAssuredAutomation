package api.endpoints;

import api.payload.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndpoints {
    /***
     * Create for performing the create,update,delete,get request
     * ***/

    public static Response createUser(User payload) {
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(payload)
                .when().post(Routes.post_user_url);
        return response;
    }

    public static Response readUser(String username) {
        Response response = given()
                .header("accept", "application/json")
                .pathParams("username", username)
                .when().get(Routes.get_user_url);
        return response;
    }

    public static Response updateUser(String username, User payload) {
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .pathParams("username", username)
                .body(payload)
                .when().put(Routes.update_user_url);
        return response;
    }

    public static Response deleteUser(String username) {
        Response response = given()
                .header("accept", "application/json")
                .pathParams("username", username)
                .when().delete(Routes.get_user_url);
        return response;
    }
}
