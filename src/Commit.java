import java.io.Serializable;

public class Commit implements Serializable {
    private String hash = "";
    Commit(String treeHash){
        this.hash = Crypto.calculateHash(treeHash);
    }

}
