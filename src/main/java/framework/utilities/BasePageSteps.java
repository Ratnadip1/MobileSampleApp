package framework.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BasePageSteps {
	private static final Logger log = Logger.getLogger(BasePageSteps.class);

	private DesiredCapabilities serviceCapabilities;
	private AppiumDriverLocalService service;

	public void startAppiumServer() {
		// TODO Auto-generated method stub
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		this.serviceCapabilities = new DesiredCapabilities();
		this.serviceCapabilities.setCapability("noReset", "false");
		//builder.withIPAddress(propertiesInstance.getProperty("ServiceIpAddress"));
		//builder.usingPort(Integer.parseInt(propertiesInstance.getProperty("ServicePort")));
		//builder.withCapabilities(this.serviceCapabilities);
		//builder.withArgument(GeneralServerFlag.LOG_LEVEL, propertiesInstance.getProperty("ServiceLogLevel"));
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		
		this.service = AppiumDriverLocalService.buildService(builder);
		
		// Launching Appium service
		this.service.start();
		log.info("============Started Appium Service============");
	}

}
