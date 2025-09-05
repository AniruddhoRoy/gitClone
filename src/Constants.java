import java.util.ArrayList;

public class Constants {
    static String system_line_separator = System.lineSeparator();
    static String Default_Storage_Directory = ".tig/";
    static String Default_Ignore_File = ".tigignore";
    static String Default_Head = "root";
    static String Working_dir = "E:\\JAVA\\Dir_Test_folder";
    static ArrayList<String> IgnoreDirsAndFiles = new ArrayList<>();
    static {
        IgnoreDirsAndFiles.add(".git");
        IgnoreDirsAndFiles.add(Default_Storage_Directory);
        IgnoreDirsAndFiles.add(Default_Ignore_File);
    }
}
