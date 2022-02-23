package com.example.chromecustombrowserdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

/**
 * @Author 有三
 * @Date 2022-02-23 13:54
 * @Description
 **/
public class Demo {
    /**
     * 存放资源的目录
     */
    private static File resourceDir;
    /**
     * 内置浏览器的目录
     */
    private static File browserDir;
    /**
     * driver路径
     */
    private static String driverPath;

    static {
        resourceDir = new File("resources");
        browserDir = new File(resourceDir, "chrome92");
        driverPath = new File(resourceDir, "chromedriver.exe").getAbsolutePath();
    }

    public static void main(String[] args) {
        WebDriver driver = createDriver();
        driver.get("http://www.baidu.com");
        System.out.println("成功正常打开浏览器");
        driver.quit();
        System.exit(0);
    }

    /**
     * 创建driver
     *
     * @return
     */
    public static WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(new File(browserDir, "Chrome/chrome.exe"));
        // ......
        WebDriver driver = new ChromeDriver(options);
        // ......
        return driver;
    }
}
