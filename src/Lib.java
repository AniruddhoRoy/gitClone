import java.nio.file.Paths;

public class Lib {
    public static String joinPath(String... parts) {
        return Paths.get("", parts).normalize().toString();
    }
    public static String objectFolder(String address) {
        return address.substring(0,2);
    }
    public static boolean isIgnoreFileOrDirectory(String fileName){
        for(String file:Constants.IgnoreDirsAndFiles){
            if(file.equals(fileName)){
                return true;
            }
        }
        return  false;
    }
}
