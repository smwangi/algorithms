package backtracking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordSearchTests {

    private final char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
    };

    @ParameterizedTest(name = "\"{0}\" exists: {1}")
    @CsvSource({
            "ABCCED, true",
            "SEE,    true",
            "ABCB,   false",  // can't reuse a cell
            "A,      true",
            "XYZ,    false",
            "ASADFBCCEESE, true"
    })
    void findsWordInGrid(String word, boolean expected) {
        assertEquals(expected, WordSearch.exists(board, word));
    }
}
