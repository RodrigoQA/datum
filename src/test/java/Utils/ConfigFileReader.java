package Utils;

import com.cucumber.listener.Reporter;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.logging.Logger;




public class ConfigFileReader {
    private final static Logger log = Logger.getLogger(ConfigFileReader.class.getName());
    public static String REPORT_CONFIG_PATH = System.getProperty("user.dir")+"/src/test/resources/extend-config.xml";
    public static String DIR_SCREENSHOT = System.getProperty("user.dir")+"/target/cucumber-reports/screenshots/";
    static String imagem = null;
    static ByteArrayInputStream byteArrayInputStream = null;





    public static void dashboardConfig(){
        try {
            Reporter.loadXMLConfig(new File(REPORT_CONFIG_PATH));
            Reporter.assignAuthor("Equipe - Software_Quality_Engineer");
            Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
            Reporter.setSystemInfo("Desafio", "Datum");




        } catch (Exception e) {
            log.info(e.getMessage());
        }

    }




}

