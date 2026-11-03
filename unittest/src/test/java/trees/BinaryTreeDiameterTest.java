package trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeDiameterTest {

    static Stream<Arguments> scenarios() {
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode balanced = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));

        // Longest path (4 -> 2 -> 5 -> 6 -> 7) skips the root
        TreeNode offRoot = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5, null, new TreeNode(6, null, new TreeNode(7)))),
                null);

        return Stream.of(
                Arguments.of("balanced", balanced, 3),
                Arguments.of("path off the root", offRoot, 4),
                Arguments.of("single node", new TreeNode(1), 0),
                Arguments.of("empty", null, 0)
        );
    }

    @ParameterizedTest(name = "{0} -> {2}")
    @MethodSource("scenarios")
    void computesDiameter(String name, TreeNode root, int expected) {
        assertEquals(expected, new BinaryTreeDiameter().diameterOfBinaryTree(root));
    }
}
