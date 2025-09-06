import java.io.Serializable;
import java.time.LocalDateTime;

public class Commit implements Serializable {
    private String rootHash;
    private String hash;
    private String priviousCommit;
    private String message;
    private String author;
    private LocalDateTime dateTime;
    Commit(String message,String priviousCommit){
        this.rootHash = Dirs.getTreeRoot();
        this.priviousCommit = priviousCommit;
        this.message = message;
        this.author = Constants.Author;
        this.dateTime = LocalDateTime.now();
        StringBuilder sb = new StringBuilder();
        sb.append(this.rootHash);
        sb.append(this.hash);
        sb.append(this.priviousCommit);
        sb.append(this.message);
        sb.append(this.author);
        sb.append(this.dateTime);
        this.hash = Crypto.calculateHash(sb.toString());
    }
    String getHash(){
        return hash;
    }
    String getMessage(){
        return message;
    }
    String getPriviousCommitHash(){
        return priviousCommit;
    }
    String getRootHash(){
        return rootHash;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Hash:"+hash+"\n");
        sb.append("RootHash:"+rootHash+"\n");
        sb.append("Privious Commit:"+priviousCommit+"\n");
        sb.append("Commit Message:"+message+"\n");
        sb.append("Author:"+author+"\n");
        sb.append("Date time:"+dateTime.format(Constants.formatter));
        return  sb.toString();
    }

}
