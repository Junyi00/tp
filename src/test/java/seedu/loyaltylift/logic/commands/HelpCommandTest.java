package seedu.loyaltylift.logic.commands;

import static seedu.loyaltylift.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.loyaltylift.logic.commands.HelpCommand.SHOWING_HELP_MESSAGE;

import org.junit.jupiter.api.Test;

import seedu.loyaltylift.model.Model;
import seedu.loyaltylift.model.ModelManager;

public class HelpCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_help_success() {
        CommandResult expectedCommandResult = new CommandResult(SHOWING_HELP_MESSAGE, true, false, null, null);
        assertCommandSuccess(new HelpCommand(), model, expectedCommandResult, expectedModel);
    }
}
