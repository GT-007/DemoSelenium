package dataproviders;

import utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import java.util.*;

public class TestData {
    @DataProvider(name = "loginData")
    public Object[][] loginTestData() {
        String path = "src/test/resources/testdata.xlsx";
        List<Map<String, String>> dataList = ExcelUtils.getTestData(path, "Sheet1", "loginTest");

        Object[][] data = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i);
        }

        return data;
    }
}
