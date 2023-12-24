package api.endpoints;

import api.payload.Pet;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetEndpoints {
    /***
     * Create for performing the create,update,delete,get request
     * ***/

    public static Response createPet(Pet payload) {
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(payload)
                .when().post(Routes.post_pet_url);
        return response;
    }

    public static Response readPet(String petId) {
        Response response = given()
                .header("accept", "application/json")
                .pathParams("petId", petId)
                .when().get(Routes.get_pet_url);
        return response;
    }

    public static Response updatePet(String petId, Pet payload) {
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .pathParams("petId", petId)
                .body(payload)
                .when().put(Routes.update_pet_url);
        return response;
    }

    public static Response deletePet(String petId) {
        Response response = given()
                .header("accept", "application/json")
                .pathParams("petId", petId)
                .when().delete(Routes.get_pet_url);
        return response;
    }
}
