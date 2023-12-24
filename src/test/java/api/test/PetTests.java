package api.test;

import api.endpoints.PetEndpoints;
import api.payload.Pet;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PetTests {
    Faker faker;
    Pet petPayload;

    @BeforeClass
    public void setupData() {
        faker = new Faker();
        petPayload = new Pet();
        petPayload.setId(faker.idNumber().hashCode());
        petPayload.setName(faker.name().firstName());
        petPayload.setCategoryId(faker.idNumber().hashCode());
        petPayload.setCategoryName(faker.name().lastName());
        petPayload.setTagsId(faker.idNumber().hashCode());
        petPayload.setTagsName(faker.name().fullName());

    }

    @Test(priority = 1)
    public void testCreatePet() {
        Response response = PetEndpoints.createPet(petPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 2)
    public void testGetPtByPetName() {
        Response response = PetEndpoints.readPet(this.petPayload.getName());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 3)
    public void testUpdatePetByPetName() {
        petPayload.setTagsName(faker.name().firstName());
        petPayload.setCategoryName(faker.name().lastName());
        petPayload.setName(faker.internet().emailAddress());

        Response response = PetEndpoints.updatePet(this.petPayload.getName(), petPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 4)
    public void testDeletePetByPetName() {
        Response response = PetEndpoints.deletePet(this.petPayload.getName());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }
}
