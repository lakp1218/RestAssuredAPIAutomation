package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static utils.TestData.*;

public class PostPostsTest extends BaseTest {
    @Test
    public void createPost() {
        given().header("Content-Type", "application/json").body(POST_BODY)
        .when().post("/posts")
        .then().statusCode(201).body("title", equalTo("New Title"), "userId", equalTo(1));
    }
}
