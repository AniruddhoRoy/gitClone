import java.io.Serializable;
import java.util.ArrayList;

public class Tree implements Serializable {
    protected String address = "";
    private String hash;
    private ArrayList<String> blobs = new ArrayList<>();
    private  ArrayList<String>tries = new ArrayList<>();
    Tree(){

    }
    Tree(String address)
    {
        this.address = address;
    }
    void addBlob(String blobHash){
        blobs.add(blobHash);
    }
    void addTree(String treeHash){
        tries.add(treeHash);
    }
    ArrayList<String > getBlobs(){
        return blobs;
    }
    ArrayList<String > getTries(){
        return tries;
    }
    String getHash(){
        return Crypto.calculateHash(toString());
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        blobs.forEach(blob->{
            sb.append("Blob:"+blob);
            sb.append('\n');
        });
        tries.forEach(tree->{
            sb.append("Tree:"+tree);
            sb.append('\n');
        });
        return sb.toString();
    }
}
