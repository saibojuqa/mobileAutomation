package com.peoplematter.utils.dataProvider;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by sai.boju on 11/20/16.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DataProviderArguments {

    String filePath();

    String sheetName();


}
