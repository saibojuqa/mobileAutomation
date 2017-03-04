package com.peoplematter.utils.dataProvider;

import com.peoplematter.core.Application;
import jxl.Cell;
import jxl.Sheet;
import jxl.read.biff.BiffException;
import lombok.extern.log4j.Log4j;
import org.testng.TestNGException;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by sai.boju on 11/20/16.
 */
@Log4j
public class ExcelDataProvider {

    @DataProvider(name = "excel")
    public static Iterator<Object[]> getDataFromFile(Method testMethod) throws Exception {
        Map<String, String> arguments = resolveDataProviderArguments(testMethod);
        List<HashMap<String, String>> dataSets = ExcelDataProvider.getDataFromExcel(Application.basedir + "/" + arguments.get("filePath"), arguments.get("sheet"));
//        log.info("File path is :" + dataSets.get(1));
        List<Object[]> data = new ArrayList<>();

        for (HashMap<String, String> dataSet : dataSets) {
            data.add(new Object[]{dataSet});
        }
        return data.iterator();
    }

    public static List<HashMap<String, String>> getDataFromExcel(String xlsPath, String sheetName) throws BiffException, IOException {
        List<HashMap<String, String>> list = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();
        jxl.Workbook workbook = jxl.Workbook.getWorkbook(new File(xlsPath));
        Sheet dataSheet = workbook.getSheet(sheetName);
        if (dataSheet == null) {
            log.error("Data Sheet Not Found in " + xlsPath + "Sheet Name : " + sheetName);
            throw new RuntimeException("Data Sheet Not Found in " + xlsPath + ", Sheet Name : " + sheetName);
        }
        Cell cellNum = dataSheet.findCell("Start Data Table");
        int startRow = cellNum.getRow() + 1;
        int endRowNum = dataSheet.findCell("End Of Data Table").getRow();
        if (endRowNum < 2) {
            throw new TestNGException("Invalid Data Format");
        } else {
            int noOfRow = endRowNum - startRow;
            // Storing the data in hash map
            for (int i = 0; i < noOfRow; i++) {
                String rowData = dataSheet.getCell(0, startRow).getContents();
                if (rowData.contains("End Of Data Set")) {
                    list.add(hm);
                    hm = new HashMap<>();
                } else {
                    hm.put(dataSheet.getCell(0, startRow).getContents(), dataSheet.getCell(1, startRow).getContents());
                }
                startRow++;
            }
        }
        return list;
    }

    protected static Map<String, String> resolveDataProviderArguments(
            Method testMethod) throws Exception {
        if (testMethod == null)
            throw new IllegalArgumentException("Test Method context cannot be null.");
        DataProviderArguments args = testMethod.getAnnotation(DataProviderArguments.class);
        if (args == null)
            throw new IllegalArgumentException("Test Method context has no DataProviderArguments annotation.");
        if (args.filePath() == null || args.sheetName() == null)
            throw new IllegalArgumentException("Test Method context has a malformed DataProviderArguments annotation.");
        Map<String, String> arguments = new HashMap<>();
        arguments.put("filePath", args.filePath());
        arguments.put("sheet", args.sheetName());
        return arguments;
    }
}


