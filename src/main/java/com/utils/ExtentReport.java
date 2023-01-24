package com.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
public static void generateReport() {
	ExtentReports Ex = new ExtentReports();
	File extentReportFile = new File(System.getProperty("user.dir")+"\\test-out\\ExtentReports\\extentReport.html");
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
	sparkReporter.config().setTheme(Theme.DARK);
	sparkReporter.config().setReportName("");
	sparkReporter.config().setTimeStampFormat("dd//mm//yyyy");
}
}
