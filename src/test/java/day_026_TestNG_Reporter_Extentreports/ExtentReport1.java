package day_026_TestNG_Reporter_Extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReport1 {
    @Test
    public void test1() {



        ExtentSparkReporter html = new ExtentSparkReporter("test-output/spark.html");

        ExtentReports report = new ExtentReports();

        report.attachReporter(html);

        // report icin test creat e edildi.simdi herseyi rapora ekleyecek
        ExtentTest test = report.createTest("test1", "My First Test Report");

        // Test icindeki gelismelere gore istenilen log kaydi tutulur
        test.info("My First Info Comment");
        test.log(Status.WARNING, "My log as Warning");
        test.warning("My log as warning ,without Status");
        test.pass("Test is passed");
        test.addScreenCaptureFromPath("test-output/Demonull24-01-03 23-41-38.png");

        //rapor sonuna eklenecek bilgiler
        report.setSystemInfo("Team", "QA Team");
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Directory", System.getProperty("user.dir"));
        report.setSystemInfo("Date Time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss")));

        report.flush();

    }
}
