package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payload.User;
import io.restassured.response.Response;
import junit.framework.Assert;

public class UserTests {
	
	
	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger = LogManager.getLogger(this.getClass());
		logger.debug("Debugging.......");
	}
	
	@Test(priority=1)
	public void testPostUser() {
		logger.info("********Creating new user*********");
		Response response = userEndPoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********Created new user*********");
	}
	
	@Test(priority=2)
	public void testGetUserByName() {
		logger.info("********Fetching user data*********");
		Response response = userEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 405);
		logger.info("********User data received*********");
	}
	
	@Test(priority=3)
	public void testUpdateUserByName() {
		//update data using payload
		logger.info("********Updating user data********");
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = userEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 405);
		
		logger.info("********User data updated*********");
		
		//checking data after update
		Response responseAfterUpdate = userEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		
		logger.info("********User data updated and verified*********");
	}
	
	@Test(priority=4)
	public void testDeleteUserByName() {
		
		logger.info("********Deleting user data*********");
		Response response = userEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********User data deleted*********");
	}

}
