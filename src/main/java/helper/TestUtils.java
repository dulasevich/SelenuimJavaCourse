package helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtils {

    public static final String USER_INFO_FILE_PATH = "src/test/resources/userInfo.json";
    private static List<User> users = new ArrayList<>();

    static {
        ObjectMapper mapper = new ObjectMapper();
        try {
            users = Arrays.asList(mapper.readValue(new File(USER_INFO_FILE_PATH ), User[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User getUser(int userNumber) {
        return users.get(userNumber);
    }
}
