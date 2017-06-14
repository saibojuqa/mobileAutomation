package com.peoplematter.tests;

import com.peoplematter.BaseTest;
import com.peoplematter.modulesList.modules.pages.WebBasePage;
import org.testng.annotations.Test;

/**
 * Created by sai.boju on 3/23/17.
 */
public class EmailSendingReport {
    @Test
    public void emailReport() throws Exception {
        //WebBasePage.report();
        BaseTest.report();
    }
}
