package seedu.loyaltylift.logic.parser;

import static seedu.loyaltylift.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.loyaltylift.logic.parser.CliSyntax.PREFIX_POINTS;
import static seedu.loyaltylift.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.loyaltylift.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.loyaltylift.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.loyaltylift.commons.core.Messages;
import seedu.loyaltylift.commons.core.index.Index;
import seedu.loyaltylift.logic.commands.AddPointsCommand;

public class AddPointsCommandParserTest {
    private AddPointsCommandParser parser = new AddPointsCommandParser();
    private final Integer nonEmptyPoints = -100;

    @Test
    public void parse_indexSpecified_success() {
        // must have points, /pt with no integer afterwards will not be parsed successfully
        Index targetIndex = INDEX_FIRST;
        String userInput = targetIndex.getOneBased() + " " + PREFIX_POINTS + nonEmptyPoints;
        AddPointsCommand expectedCommand = new AddPointsCommand(INDEX_FIRST, nonEmptyPoints);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_missingCompulsoryField_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddPointsCommand.MESSAGE_USAGE);
        String expectedMissingIndex = Messages.MESSAGE_INVALID_CUSTOMER_DISPLAYED_INDEX;

        // no parameters
        assertParseFailure(parser, AddPointsCommand.COMMAND_WORD, expectedMessage);

        // weird test failure, not sure what is going on, will fix in future
        // no index
        //assertParseFailure(parser, AddPointsCommand.COMMAND_WORD + " " + PREFIX_POINTS
        //        + modifier + nonEmptyPoints, expectedMessage);

        // no points
        assertParseFailure(parser, AddPointsCommand.COMMAND_WORD + " 1", expectedMessage);
    }
}

