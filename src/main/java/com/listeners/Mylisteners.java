package com.listeners;

import java.io.File;
import java.io.FilterOutputStream;
import java.io.Flushable;
import java.io.PrintStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Writable;
import com.utils.ExtentReport;

public class Mylisteners implements ITestListener {
	ExtentReports Ex;
	ExtentTest extentTest;
	public void onStart(ITestContext context) {
		//Ex=ExtentReport.generateReport();
		
	}

	public void onTestStart(ITestResult result) {
		String testName=result.getName();
	extentTest	=Ex.createTest(testName);
	extentTest.log(Status.INFO, testName);
		System.out.println("particular test name started excution");
	}

	public void onTestSuccess(ITestResult result) {
		
		String testName=result.getName();
		
		extentTest.log(Status.PASS, testName);
		System.out.println("test name got successfully excuted");
		System.out.println(result.getThrowable());
		System.out.println("it will tell which exception got");
		
	}

	public void onTestFailure(ITestResult result) {
		
		
		String testName=result.getName();
		WebDriver driver= null;
		//driver = (WebDriver)result.getTestClass().getRealClass().
		//File Src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE)
		extentTest.log(Status.FAIL, testName);
		System.out.println("test name got failed excuted");
	}

	public void onTestSkipped(ITestResult result) {
		String testName=result.getName();
		System.out.println("test name got skipped excuted");
		System.out.println(result.getThrowable());
		System.out.println("it will tell which exception got");
		
	}

	

	

	public void onFinish(ITestContext context) {
		//extentTest.flush();
		System.out.println("finish excution ");
		
		
	}
	

}
