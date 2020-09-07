package com.testng_reporter.demo.utils;

import com.testng_reporter.demo.constant.Constant;
import com.testng_reporter.demo.constant.TableName;
import com.testng_reporter.demo.constant.Xpath;

public class AppUtility {
    
    static String[][] serverDEetails    = ExcelUtility.getTableArray(Constant.DATA_FILE, Constant.DATA_SHEET1, TableName.LogIn.URL);
    
    static String[][] logIn_Credentials = ExcelUtility.getTableArray(Constant.DATA_FILE, Constant.DATA_SHEET1, TableName.LogIn.LOGIN_Credentials);
    
    /**
     * Log in with testuser1.
     */
    public static void LOG_IN_TEST_USER(int userid) {
        
        Utility.OpenApp(serverDEetails[0][1], serverDEetails[0][0]);
        Utility.SendKeys(Xpath.LogIn.USER_NAME, logIn_Credentials[userid][0]);
        Utility.SendKeys(Xpath.LogIn.PASS_WORD, logIn_Credentials[userid][1]);
        Utility.Click(Xpath.LogIn.SIGN_IN);
    }
    
}
