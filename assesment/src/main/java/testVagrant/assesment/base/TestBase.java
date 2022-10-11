package testVagrant.assesment.base;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import testVagrant.assesment.utilities.JsonParserUtility;

public class TestBase {

	protected JsonParserUtility jsonParserUtility;


	@SuppressWarnings("unchecked")
	public List<Map<String, String>> getPlayerNodevalues(String fileName, String nodeValue)
			throws IOException, ParseException {

		Reporter.log("Step -1 Load The Json " + fileName + " and Parse for " + nodeValue);
		Map<Object, Object> teamMap = (Map<Object, Object>) jsonParserUtility.getJSONObject(fileName);
		return (List<Map<String, String>>) teamMap.get(nodeValue);

	}
}
