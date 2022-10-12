package helper;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {

    public static JsonObject readFromJson(String Path) {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(Path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return JsonParser.parseReader(reader).getAsJsonObject();
    }
}
