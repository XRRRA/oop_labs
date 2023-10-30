package Laboratory2.commands;

import Laboratory2.entities.Commit;

public class CommitCommand implements Command {
    @Override
    public void invoke() {
        Commit.makeCommit();
        System.out.println("Commit performed!");
    }
}
