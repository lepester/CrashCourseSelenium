package factory;

public class DriverFactoryManager {

        private DriverFactoryManager() {

        }

        public static DriverManager getDriver(DriverType type){
        DriverManager driver;

        switch (type) {
            case CHROME:
                driver = new ChromeDriverManager();
                break;
            case EDGE:
                driver = new EdgeDriverManager();
                break;
            default:
                throw new RuntimeException("No such Driver");
        }
        return driver;
    }
}
