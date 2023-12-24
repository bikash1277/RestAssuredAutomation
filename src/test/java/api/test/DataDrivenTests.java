package api.test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviderUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenTests {
    User userPayload;

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviderUtil.class)
    public void testCreateUser(String UserId, String UserName, String FirstName,
                               String LastName, String Email, String Password, String Phone) {

        userPayload = new User();
        userPayload.setId(Integer.parseInt(UserId));
        userPayload.setUsername(UserName);
        userPayload.setFirstName(FirstName);
        userPayload.setLastName(LastName);
        userPayload.setEmail(Email);
        userPayload.setPassword(Password);
        userPayload.setPhone(Phone);
        Response response = UserEndpoints.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviderUtil.class)
    public void testGetUserByUserName(String userName) {
        Response response = UserEndpoints.readUser(userName);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviderUtil.class)
    public void testDeleteUserByUserName(String userName) {
        Response response = UserEndpoints.deleteUser(userName);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }
}
