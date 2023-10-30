package Laboratory2.commands;

public class CommitCommand implements Command {
    @Override
    public void invoke() {
        Commit.makeCommit();
        System.out.println("Commit performed!");
    }
}
