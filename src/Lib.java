import java.nio.file.Paths;
import java.io.File;
public class Lib {
    public static String joinPath(String... parts) {
        return Paths.get("", parts).normalize().toString();
    }
    public static String objectFolder(String address,String type) {
        return joinPath(type,address.substring(0,2));
    }
    public static boolean isIgnoreFileOrDirectory(File file){
        for(String fileName:Constants.IgnoreDirsAndFiles){
            if(file.isDirectory()){
                if(fileName.equals(file.getName()+"/")){
                    return true;
                }
            }else{
                if(fileName.equals(file.getName())){
                    return true;
                }
            }
        }
        return  false;
    }
    public static boolean isNameInvalid(String str){
        if (str.contains(" ")) {
            return true;
        } else {
            return false;
        }
    }
}
