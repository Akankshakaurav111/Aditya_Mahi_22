package practice.datadriventesting;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadTheDataFromJSONTest {

	public static void main(String[] args) throws IOException, ParseException {
		//Step1: parse JSON physical file into JAVA object using JSON class
		FileReader fis = new FileReader("C:\\Users\\Admin\\Desktop\\data\\appCommonData.json");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(fis);
		
		//Step2: Covert java Object into JSONObject using down casting
		JSONObject map=(JSONObject)obj;
		//step3: get the value from json file using key
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("timeOut"));
		
		

	}

}
