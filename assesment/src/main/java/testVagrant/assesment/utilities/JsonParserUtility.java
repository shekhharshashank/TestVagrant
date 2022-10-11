package testVagrant.assesment.utilities;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParserUtility {

	private JSONParser jsonParser;
	private FileReader fileReader;
	private Object jsonObj;

	public Object getJSONObject(String fileName) throws IOException, ParseException {

		jsonParser = new JSONParser();
		fileReader = new FileReader("resources//" + fileName + ".json");
		jsonObj = jsonParser.parse(fileReader);

		return jsonObj;
	}

}
