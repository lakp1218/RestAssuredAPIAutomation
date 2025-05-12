package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static utils.TestData.*;

public class PutPostsTest extends BaseTest {
    @Test
    public void updatePost() {
        given().header("Content-Type", "application/json").body(UPDATED_BODY)
        .when().put("/posts/1")
        .then().statusCode(200).body("title", equalTo("Updated Title"));
    }
}
