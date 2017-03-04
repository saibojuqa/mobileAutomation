package com.peoplematter.selenium.utils;

import com.peoplematter.core.Application;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;

/**
 * Created by sai.boju on 11/24/16.
 */
@Log4j
public class Screenshot {

    public static WebDriver driver = Application.getAndroidDriver();

    public static File takeScreenshot(String filePath) {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        if (takesScreenshot == null)
            return null;

        OutputType<byte[]> target = OutputType.BYTES;
        byte screenshotAsPngBytes[] = takesScreenshot.getScreenshotAs(target);

        File targetFile = new File(filePath + ".png");
        try {
            OutputStream outputStream = new FileOutputStream(targetFile);
            outputStream.write(screenshotAsPngBytes);
            outputStream.close();
            return targetFile;
        } catch (FileNotFoundException e) {
            log.error("File not found ", e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.error("IO exception ", e);
            throw new RuntimeException(e);
        }
    }

}
