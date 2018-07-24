import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class CheckDir {

    public static void main(String[] args) {
        Path pathToDir = Paths.get("/home/necalai/IdeaProjects/checker_bot/Test/TestDir");

        System.out.println(isDirExist(pathToDir));
    }


    public static boolean isDirExist(Path pathToDir) {

        LocalDate date = Instant.ofEpochMilli(pathToDir.toFile().lastModified()).atZone(ZoneId.systemDefault()).toLocalDate();

        return date.equals(LocalDate.now());
    }
}
