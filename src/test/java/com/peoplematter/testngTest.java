package com.peoplematter;

import org.testng.annotations.Test;

import com.peoplematter.core.Application;

import lombok.extern.log4j.Log4j;

import java.io.File;

@Log4j
public class testngTest extends  BaseTest{

    @Test
    public void Logger() {
      //  String filePath="/Users/sai.boju/Desktop/PeopleMatter-automation/src/test/resources/Template.xls";

        ClassLoader classLoader = getClass().getClassLoader();
        classLoader.getResource("Template.xls");
        log.info("Running first testcase");


    }


}
