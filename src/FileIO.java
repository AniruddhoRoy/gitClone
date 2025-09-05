import java.io.*;

public class FileIO {
//    private String path;
//    private String Data_extract_from_file;
//    private String Data_inserted_into_file;
//    FileIO(String filename){
//        this.path = filename;
//    }
    static String read(String path){
        String Data_extract_from_file="",temp;
        StringBuilder data = new StringBuilder();
        String lineSeparator = System.lineSeparator();
        try{
            FileReader infile = new FileReader(path);
            BufferedReader br= new BufferedReader(infile);
            while((temp=br.readLine())!=null){
                    data.append(temp).append(lineSeparator);
            }
            br.close();
            infile.close();
            Data_extract_from_file = data.toString();

        }catch (Exception e){
            System.out.println(e);
        }
        return Data_extract_from_file;
    }
    static void save(Blob blob,String rootPath){
        try{
            String path = Lib.joinPath(rootPath,Constants.Default_Storage_Directory,Lib.objectFolder(blob.getHash()),blob.getHash());

            File file = new File(path);

            if(file.exists()){
//                System.out.println("File Exist - Blob");
                return ;
            }
            System.out.println("file[save]:"+blob.address);
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream  fos= new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(blob);
        }catch (Exception e){
            System.out.println("File Writing Error:");
            System.out.println(e);
        }


    }
    static void save(Tree tree,String rootPath){
        try{
            String path = Lib.joinPath(rootPath,Constants.Default_Storage_Directory,Lib.objectFolder(tree.getHash()),tree.getHash());

            File file = new File(path);

            if(file.exists()){
//                System.out.println("File Exist -tree");
                return ;
            }
            System.out.println("Tree[save]:"+tree.address);
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream  fos= new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(tree);
        }catch (Exception e){
            System.out.println("File Writing Error:");
            System.out.println(e);
        }


    }

}
