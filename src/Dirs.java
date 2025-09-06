
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Dirs {
    static String getTreeRoot(){

        readIgnoreFile();
        File root = new File(Constants.Working_dir);
       return traverse(root,root);
    }
    static String traverse(File root, File current){
        Tree tree = new Tree(root.toPath().relativize(current.toPath()).toString());
        File[] files = current.listFiles();
        for (File file : files) {
            // relative path from the original root
            Path relativePath = root.toPath().relativize(file.toPath());
//            System.out.println(relativePath);
//            System.out.println(file.getName());
//            Constants.Default_Storage_Directory.equals(file.getName())
            if (Lib.isIgnoreFileOrDirectory(file)) {
                continue;
            }

            if (file.isDirectory()) {
                tree.addTree(traverse(root, file));// pass root unchanged
            }else{
                Blob blob = new Blob(FileIO.read(file.toString()),relativePath.toString());
                tree.addBlob(blob.getHash());
                FileIO.save(blob,Constants.Working_dir);
            }
        }
//        System.out.println("===========================");
//        System.out.println("Path:"+current.getPath());
//        System.out.println(tree);
//        System.out.println("===========================");
        FileIO.save(tree,Constants.Working_dir);
        return tree.getHash();
    }
    static String getTreeRoot_withoutStoring(){

        readIgnoreFile();
        File root = new File(Constants.Working_dir);
        return traverse_withOutStoring(root,root);
    }
    static String traverse_withOutStoring(File root, File current){
        Tree tree = new Tree(root.toPath().relativize(current.toPath()).toString());
        File[] files = current.listFiles();
        for (File file : files) {
            // relative path from the original root
            Path relativePath = root.toPath().relativize(file.toPath());
//            System.out.println(relativePath);
//            System.out.println(file.getName());
//            Constants.Default_Storage_Directory.equals(file.getName())
            if (Lib.isIgnoreFileOrDirectory(file)) {
                continue;
            }

            if (file.isDirectory()) {
                tree.addTree(traverse_withOutStoring(root, file));// pass root unchanged
            }else{
                Blob blob = new Blob(FileIO.read(file.toString()),relativePath.toString());
                tree.addBlob(blob.getHash());

            }
        }
//        System.out.println("===========================");
//        System.out.println("Path:"+current.getPath());
//        System.out.println(tree);
//        System.out.println("===========================");

        return tree.getHash();
    }
    static void readIgnoreFile(){
      String[] lines =  FileIO.read(Lib.joinPath(Constants.Working_dir,Constants.Default_Ignore_File)).split(Constants.system_line_separator);
      for(String line :lines)
      {
          Constants.IgnoreDirsAndFiles.add(line);
      }
    }
}
