
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Dirs {
    private String path;
    private ArrayList<Blob> blobs = new ArrayList<>();
    Dirs(String path){
        this.path = path;
    }
    //Delete this method
    private void getDirs(){
        Path folder = Paths.get(path);
        try {
            Files.walk(folder).forEach(path -> {
                Path relativePath = folder.relativize(path);
                if (Files.isDirectory(path)) {
                    System.out.println("[DIR]" + relativePath);
                } else {
                    System.out.println("[FILE]" + relativePath);
                    blobs.add(new Blob(FileIO.read(path.toString()),relativePath.toString()));
                }
            });
        } catch (Exception e) {
            // TODO: handle exception
//            System.out.println(e);
        }
    }
    String getTreeRoot(){

        readIgnoreFile();
        File root = new File(path);
       return traverse(root,root);
    }
    String traverse(File root, File current){
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
                FileIO.save(blob,path);
            }
        }
//        System.out.println("===========================");
//        System.out.println("Path:"+current.getPath());
//        System.out.println(tree);
//        System.out.println("===========================");
        FileIO.save(tree,path);
        return tree.getHash();
    }
    void readIgnoreFile(){
      String[] lines =  FileIO.read(Lib.joinPath(path,Constants.Default_Ignore_File)).split(Constants.system_line_separator);
      for(String line :lines)
      {
          Constants.IgnoreDirsAndFiles.add(line);
      }
    }
    void getBlobs(){
        blobs.forEach(blob->{
            System.out.println(blob);
        });
    }
}
