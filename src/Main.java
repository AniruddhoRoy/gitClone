//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//


//        SystemHeads.printHeads();
//        SystemHeads.addHead("RadhaKrishna1");
//        SystemHeads.switchHead("root");
//        System.out.println("Active:"+SystemHeads.getActiveHead().getHeadName());
        try (Heads SystemHeads = new Heads()) {
//            SystemHeads.printHeads();
            SystemHeads.exportCommit();
//            System.out.println(FileIO.readBlob("4ec0cb640bf1d20d4915d652eb7a2bb25db15335"));
//            SystemHeads.addHead("Second_Root");
//            SystemHeads.switchHead("Second_Root");
//            SystemHeads.getActiveHead().update("first_commit_from_second Root");
            System.out.println(SystemHeads.getActiveHead().isFilesChange());
//            System.out.println(FileIO.readCommits("873527db1cc54c1f6c013f86e7ce42cfb1a5d716").getMessage());
//            for(Commit commit : SystemHeads.getActiveHead().getCommits()){
////                System.out.println(commit.getMessage());
//                System.out.println(commit);
//            }

        }
    }
}