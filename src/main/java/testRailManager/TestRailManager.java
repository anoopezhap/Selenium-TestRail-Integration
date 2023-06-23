package testRailManager;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestRailManager {

    public static String TEST_RUN_ID = "1";

    public static String TEST_RAIL_USERNAME = "anoopezhap@gmail.com";
    public static String TEST_RAIL_PASSWORD = "P@ssword123";

    public static String TEST_RAIL_SERVER_URL = "https://anoopautomation.testrail.io/";

    public static int TEST_CASE_PASS = 1;
    public static int TEST_CASE_FAIL = 5;

    public static void addTestCaseResult(String testCaseID, int status, String error) throws APIException, IOException {
        String testRunID = TEST_RUN_ID;
        APIClient client = new APIClient(TEST_RAIL_SERVER_URL);
        client.setUser(TEST_RAIL_USERNAME);
        client.setPassword(TEST_RAIL_PASSWORD);

        Map<String,Object> data = new HashMap<>();
        data.put("status_id", status);
        data.put("comment" , "The test status  " + error);
        client.sendPost("add_result_for_case/"+testRunID+"/"+testCaseID, data);
    }


}
