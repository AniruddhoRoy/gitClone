import java.util.ArrayList;

public class Constants {
    static String system_line_separator = System.lineSeparator();
    static String Default_Storage_Directory = ".tig";
    static ArrayList<String> IgnoreDirsAndFiles = new ArrayList<>();
    static {
//        IgnoreDirsAndFiles.add(".git");
        IgnoreDirsAndFiles.add(".tig");
        IgnoreDirsAndFiles.add(".tigignore");
    }
}
