package utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;


public class Utils {
    public static void setEnvVar(String key, String value) throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration("./src/test/resources/config.properties");
        config.setProperty(key, value);
        config.save();
    }


//    public static void saveIntoJsonFile(JSONObject result) throws IOException {
//        FileWriter file = new FileWriter("./src/test/resources/authInfo.json");
//        file.write(result.toString(4)); // Pretty print with indentation
//        file.flush();
//    }


    public static String nextMondayDate() {
        LocalDate today = LocalDate.now();
        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        return nextMonday.format(formatter);
    }

    public static String MondayDateFormat() {
        LocalDate today = LocalDate.now();
        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return nextMonday.format(formatter);
    }

    public static String NextNextMondayDateFormat() {
        LocalDate today = LocalDate.now();
        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).plusDays(7);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return nextMonday.format(formatter);
    }
}
