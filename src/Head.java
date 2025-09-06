import java.io.Serializable;
import java.util.ArrayList;

public class Head implements Serializable {

    private String currentCommitHash = null;
    private boolean isActiveHead = false;
    private String headName ;
    Head(String name,String currentCommitHash){
        this.headName = name;
        Commit commit = new Commit("Added Head ["+name+"]",currentCommitHash);
        this.currentCommitHash = commit.getHash();
        FileIO.save(commit);
    }
    void update(String commitMessage){
            Commit commit = new Commit(commitMessage,currentCommitHash);
            currentCommitHash = commit.getHash();
            FileIO.save(commit);
    }
    boolean isFilesChange(){
        Commit currentCommit = FileIO.readCommits(currentCommitHash);
        if(currentCommit.getRootHash().equals(Dirs.getTreeRoot_withoutStoring())){
//            System.out.println("Already in sync");
            return false;
        }
//        if(currentCommitHash.equals(Crypto.calculateHash(Dirs.getTreeRoot_withoutStoring()))){
//
//            System.out.println("Already in sync");
//            return false;
//
//        }
//        System.out.println(currentCommitHash);
//        System.out.println(Crypto.calculateHash(Dirs.getTreeRoot_withoutStoring()));
        return true;
    }
    boolean isActiveHead(){
        return isActiveHead;
    }
    void changeActiveAtatus(boolean status){
        isActiveHead = status;
    }
    String getHeadName(){
        return headName;
    }
    String getCurrentCommitHash(){
        return currentCommitHash;
    }
    ArrayList<Commit> getCommits(){
        ArrayList<Commit> commits = new ArrayList<>();
        String commitHash = this.currentCommitHash;
        while (commitHash!=null)
        {
            Commit commit = FileIO.readCommits(commitHash);
            commits.add(commit);
            commitHash = commit.getPriviousCommitHash();
        }
        return commits;
    }

}
class Heads implements Serializable , AutoCloseable  {
    private ArrayList<Head> heads = new ArrayList<>();
   Heads(){

        if(FileIO.readHeads()==null){
//            System.out.println("Reached");
            Head root = new Head(Constants.Default_Head,null);

            root.changeActiveAtatus(true);
            heads.add(root);
            FileIO.save(this);

        }
        heads = FileIO.readHeads().heads;

   }
   void addHead(String headName)
   {
       if(isHeadExist(headName))
       {
           System.out.println("Head Exist");
           return;
       }
       if(Lib.isNameInvalid(headName))
       {
           System.out.println("No Special Character including space");
           return;
       }
       heads.add(new Head(headName,getActiveHead().getCurrentCommitHash()));
       FileIO.save(this);
   }
   void switchHead(String headName){
       if(!isHeadExist(headName)){
           System.out.println("Head Not Exist");
           return;
       }
       for(Head head : heads)
       {
           if(headName.equals(head.getHeadName()))
           {
               head.changeActiveAtatus(true);
           }else{
               head.changeActiveAtatus(false);
           }
       }
       FileIO.save(this);
   }
   Head getActiveHead(){
       for(Head head : heads)
       {
           if(head.isActiveHead()){
               return head;
           }
       }

       heads.getFirst().changeActiveAtatus(true);
       FileIO.save(this);
       return heads.getFirst();
   }
   boolean isHeadExist(String headName){
       for(Head head : heads)
       {
           if(headName.equals(head.getHeadName())){
               return true;
           }
       }
       return false;
   }
    void printHeads(){
       for(Head head : heads)
       {
           System.out.println(head.getHeadName()+" "+head.isActiveHead());
       }
    }
    public void close() {
        FileIO.save(this);
    }


}
