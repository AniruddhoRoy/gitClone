import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Constants {
    static String system_line_separator = System.lineSeparator();
    static String Default_Storage_Directory = ".tig/";
    static String Default_Ignore_File = ".tigignore";
    static String Default_Head = "root";
    static String File_contains_Head = "Head";
    static String Working_dir = "E:\\JAVA\\Dir_Test_folder";
    static String Output_dir = "E:\\JAVA\\Dir_Test_output_folder";
    static String Author = "aniruddho@gmail.com";
    static ArrayList<String> IgnoreDirsAndFiles = new ArrayList<>();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy,HH:mm:ss");
    static {
        IgnoreDirsAndFiles.add(".git");
        IgnoreDirsAndFiles.add(Default_Storage_Directory);
        IgnoreDirsAndFiles.add(Default_Ignore_File);
    }
}
