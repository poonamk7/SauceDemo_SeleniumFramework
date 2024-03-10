package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.config.ConfigFactory;

public final class Driver {

	private Driver() {

	}

	public static WebDriver driver;

	public static void initDriver() {

		String browser = ConfigFactory.getConfig().browser();
		if (DriverManager.getDriver() == null) {
			driver = DriverFactory.getDriver(browser);
			DriverManager.setDriver(driver);

			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(ConfigFactory.getConfig().timeout()));

			DriverManager.getDriver().get(ConfigFactory.getConfig().url());
		}

	}

	public static void quitDriver() {
		if (DriverManager.getDriver() != null)
			DriverManager.getDriver().quit();

		DriverManager.setDriver(null);
	}

}
