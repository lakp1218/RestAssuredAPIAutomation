package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetPostsTest extends BaseTest {
    @Test
    public void getPost() {
        Response response= given().when().get("/posts/1");

        // Print the entire response body as string
        System.out.println("Response Body:\n" + response.getBody().asString());

        // Optionally print status code and headers too
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Headers:\n" + response.getHeaders());
        response.then().statusCode(200).body("id", equalTo("1"));

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");

        // Extract values from response body using JsonPath
        int id = response.jsonPath().getInt("id");
        int userId = response.jsonPath().getInt("userId");
        String title = response.jsonPath().getString("title");

        // Assert values in response body
        Assert.assertEquals(id, 1, "Post ID should be 1");
        Assert.assertEquals(userId, 1, "User ID should be 1");
        Assert.assertNotNull(title, "Title should not be null");
    }
}
