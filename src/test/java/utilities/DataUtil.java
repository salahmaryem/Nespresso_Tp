package utilities;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import tests.BaseTests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataUtil extends BaseTests {
    @DataProvider(name = "data")
    public Object[][] testData() throws IOException {
        // Read the JSON file as a string
        String json = new String(Files.readAllBytes(Paths.get("src/main/resources/data.json")));

        // Convert the JSON string to a JSONArray
        JSONArray jsonArray = new JSONArray(json);

        // Create a two-dimensional array to store the data
        Object[][] data = new Object[jsonArray.length()][];

        // Loop through the JSON objects
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            // Extract the values from the JSON object
            String type = jsonObject.getString("type");
            String name = jsonObject.getString("name");
            int quantity = jsonObject.getInt("quantity");

            // Store the data in the array
            data[i] = new Object[]{type, name, quantity};
        }
        return data;
    }

}

