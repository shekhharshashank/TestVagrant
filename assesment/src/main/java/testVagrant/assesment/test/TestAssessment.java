package testVagrant.assesment.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testVagrant.assesment.base.TestBase;
import testVagrant.assesment.utilities.JsonParserUtility;

public class TestAssessment extends TestBase {

	private int playerCount;
	public static final String TEAM_RCB = "TeamRCB";
	public static final String PLAYER_NODE = "player";
	private List<Map<String, String>> player;

	@BeforeMethod(enabled = true)
	public void setupForTest() throws IOException, ParseException {
		jsonParserUtility = new JsonParserUtility();
		playerCount = 0;
		player = getPlayerNodevalues(TEAM_RCB, PLAYER_NODE);
	}

	@Test(enabled = true)
	public void test_that_validates_the_team_has_only_4_Foreign_players() {

		Reporter.log("Step -2 Iterate through Player List to find country Value");
		for (Map<String, String> mp : player) {

			if (!mp.get("country").equalsIgnoreCase("India")) {

				playerCount++;
			}

		}
		Reporter.log("Step -3 Assert that player count is 4 or lesser");
		Assert.assertTrue(playerCount <= 4, "Foreign Player count is - " + playerCount);

	}

	@Test(enabled = true)
	public void test_that_validates_that_there_is_atleast_one_wicket_Keeper() {

		Reporter.log("Step -2 Iterate through Player List to find country Value");
		for (Map<String, String> mp : player) {

			if (mp.get("role").equalsIgnoreCase("Wicket-keeper")) {

				playerCount++;
			}

		}
		Reporter.log("Step -3 Assert that player count is 1 atleast");
		Assert.assertTrue(playerCount >= 1, "Wicket-keeper count is - " + playerCount);
	}

	@AfterMethod(enabled = true)
	public void tearUp() throws IOException, ParseException {
		jsonParserUtility = null;
		player = null;
	}
}
