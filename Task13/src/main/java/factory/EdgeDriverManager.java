package factory;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;

import java.io.IOException;

public class EdgeDriverManager extends DriverManager {
    private EdgeDriverService edgeService;

    @Override
    protected void startService() {
        if(edgeService == null) {
            System.setProperty("webdriver.edge.driver", "browserDrivers/msedgedriver.exe");
            edgeService = new EdgeDriverService.Builder().usingAnyFreePort().build();
            try {
                edgeService.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopService() {
        if (edgeService.isRunning() && edgeService != null) {
            edgeService.stop();
        }
    }

    @Override
    protected void createDriver() {
        driver = new EdgeDriver(edgeService);
        driver.manage().window().maximize();
    }
}
