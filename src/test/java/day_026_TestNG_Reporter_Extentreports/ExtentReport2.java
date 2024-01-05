package day_026_TestNG_Reporter_Extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ExtentReport2 {
    ExtentSparkReporter html;
    ExtentReports reports;
    ExtentTest test1, test2, test3;


    @BeforeSuite
    public void beforesuit() {

        html = new ExtentSparkReporter("report.html");
        reports = new ExtentReports();
        reports.attachReporter(html);

    }

    @AfterSuite
    public void aftersuite() {
        reports.setSystemInfo("Team", "A Team");
        reports.setSystemInfo("Os", System.getProperty("os.name"));
        reports.setSystemInfo("Directory", System.getProperty("use.dir"));
        reports.setSystemInfo("DateTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss")));
        reports.flush();
    }

    @Test
    public void test1() {
        test1 = reports.createTest("test1", "Mein Erster test");
        test1.log(Status.INFO, "Test basladi");
        try {
            test1.warning("Asserte dikkat...");
            Assert.assertEquals(1, new Random().nextInt(3)+1); // 1,2,3 secsin diye +1 eklendi yoksa 2 ye kadar sayasrdi
            test1.pass("Test is passed");
        } catch (Exception |AssertionError e) {
            test1.fail("Test is faill\n" + e.getMessage());
            Assert.fail("test1 fail"); // asserti yakaladim fail devam eder
        }
        test1.info("Test bitti")
        ;

    }

    @Test
    public void test2() {
        test2 = reports.createTest("test2", "Mein Erster test");
        test2.log(Status.INFO, "Test basladi");
        try {
            test2.warning("Asserte dikkat...");
            Assert.assertEquals(1, new Random().nextInt(3)+1); // 1,2,3 secsin diye +1 eklendi yoksa 2 ye kadar sayasrdi
            test2.pass("Test is passed");
        } catch (Exception |AssertionError e) {
            test2.fail("Test is faill\n" + e.getMessage());
            Assert.fail("test2 fail"); // asserti yakaladim fail devam eder
        }
        test2.info("Test bitti")
        ;

    }

    @Test
    public void test3() {
        test3 = reports.createTest("test3", "Mein Erster test");
        test3.log(Status.INFO, "Test basladi");
        try {
            test3.warning("Asserte dikkat...");
            Assert.assertEquals(1, new Random().nextInt(3)+1); // 1,2,3 secsin diye +1 eklendi yoksa 2 ye kadar sayasrdi
            test3.pass("Test is passed");
        } catch (Exception |AssertionError e) {
            test3.fail("Test is faill\n" + e.getMessage());
            Assert.fail("test3 fail"); // asserti yakaladim fail devam eder
        }
        test3.info("Test bitti")
        ;
        // warning sarilar tester gatasi,kirmizilar devoloper hatasidir

    }
}