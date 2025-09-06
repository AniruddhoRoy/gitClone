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
            SystemHeads.printHeads();
//            SystemHeads.addHead("root2_from_roo1");
//            SystemHeads.switchHead("root");
//            SystemHeads.getActiveHead().update("RadhaMadhob3 - from roo1");
            System.out.println(SystemHeads.getActiveHead().isFilesChange());
//            System.out.println(FileIO.readCommits("873527db1cc54c1f6c013f86e7ce42cfb1a5d716").getMessage());
            for(Commit commit : SystemHeads.getActiveHead().getCommits()){
//                System.out.println(commit.getMessage());
                System.out.println(commit);
            }

        }
    }
}