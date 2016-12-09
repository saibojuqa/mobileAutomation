package com.peoplematter.tests;

import com.peoplematter.core.Application;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import com.peoplematter.utils.dataProvider.ExcelDataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;

/**
 * Created by sai.boju on 11/22/16.
 */
public class SampleTest2 {

    public static final String FILE_PATH = "/testData/Template.xls";
    Application application = new Application();


    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T1")
    public void test1(Map<String, String> testData) {
        System.out.println("sample");
        /*ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("Template.xls").getFile());
        System.out.println(file.getAbsolutePath());*/

//        File file2=new File("resources/Template.xls");

        System.out.println(testData.get("measures"));


        //  Im trying something to read file, but not recosnizing resource folser, let me search in google


    }
}
