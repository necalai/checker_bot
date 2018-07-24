import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {
    public static final Path CONFIGURATION_BOT_FILE = Paths.get("./config/bot/bot.properties");

    public static String BOT_USERNAME;
    public static String BOT_TOKEN;

    public static void load() {
        Properties botSettings = new Properties();

        try (InputStream inputStream =  new FileInputStream(CONFIGURATION_BOT_FILE.toFile())) {
            botSettings.load(inputStream);
            System.out.println("Конфигурация бота успешно загружена");
        } catch (Exception e) {
            System.out.println("При загрузке конфигурации бота произошла ошибка");
            e.getStackTrace();
        }

        BOT_USERNAME = botSettings.getProperty("BotUsername", "CheckerBot");
        BOT_TOKEN = botSettings.getProperty("BotToken", "618296559:AAHGEn0HFqCxh75PNAIqhM8ioFMLOzDLeho");
    }


}
