public class MaxHeapTester {

    private enum Result {
        IndexOutOfBounds, NoSuchElement, NoException,
        UnexpectedException, True, False, Pass,
        Fail, MatchingValue, ValidString
    }

    public static final Integer ELEMENT_A = 1;
    public static final Integer ELEMENT_B = 2;
    public static final Integer ELEMENT_C = 3;
    public static final Integer ELEMENT_D = 4;
    public static final Integer ELEMENT_E = 5;
    public static final Integer ELEMENT_F = 6;

    private Integer passes = 0;
    private Integer fails = 0;
    private Integer totalTests = 0;

    public static void main(String[] args) {
        MaxHeapTester tester = new MaxHeapTester();
    }

    public MaxHeapTester() {
        runTests();

        // Possible Scenarios
        Integer[] LIST_A = {ELEMENT_A};
        String STRING_A = "A";
        Integer[] LIST_B = {ELEMENT_B};
        String STRING_B = "B";
        Integer[] LIST_C = {ELEMENT_C};
        String STRING_C = "C";
        Integer[] LIST_D = {ELEMENT_D};
        String STRING_D = "D";
        Integer[] LIST_E = {ELEMENT_E};
        String STRING_E = "E";
        Integer[] LIST_F = {ELEMENT_F};
        String STRING_F = "F";

    }

    private void printTest(String description, boolean result) {

        totalTests++;

        if (result) {

            passes++;
            System.out.printf("TEST: " + description + " passed");

        } else {

            fails++;
            System.out.printf("TEST: " + description + " failed");

        }

        System.out.printf("\n");

    }

    private void runTests() {

        testEmptyHeap(newHeap(), "EMPTY HEAP");
    }

    private MaxHeap<Integer> newHeap() {
        return new MaxHeap<Integer>();
    }

    private void testEmptyHeap(MaxHeap<Integer> heap, String testName) {
        System.out.printf("\nTEST: %s\n", testName);
        System.out.println("***********************");
        try {

            // parent
            printTest(testName + "_parent(-1)", testParent(heap, -1, null, Result.IndexOutOfBounds));
            printTest(testName + "_parent(0)", testParent(heap, 0, null, Result.IndexOutOfBounds));
            printTest(testName + "_parent(1)", testParent(heap, 1, null, Result.IndexOutOfBounds));

            // left child
            printTest(testName + "_leftChild(-1)", testLeftChild(heap, -1, null, Result.IndexOutOfBounds));
            printTest(testName + "_leftChild(0)", testLeftChild(heap, 0, null, Result.IndexOutOfBounds));
            printTest(testName + "_leftChild(1)", testLeftChild(heap, 1, null, Result.IndexOutOfBounds));

            // right child
            printTest(testName + "_rightChild(-1)", testRightChild(heap,-1, null, Result.IndexOutOfBounds));
            printTest(testName + "_rightChild(0)", testRightChild(heap,0, null, Result.IndexOutOfBounds));
            printTest(testName + "_rightChild(-1)", testRightChild(heap,1, null, Result.IndexOutOfBounds));

            // swap
            printTest(testName + "_swap(-1, 0)", testSwap(heap, -1, 0, Result.IndexOutOfBounds));
            printTest(testName + "_swap(0, 1)", testSwap(heap, 0, 1, Result.IndexOutOfBounds));

        } catch (Exception e) {
            System.out.printf("** UNABLE TO COMPLETE %s TESTS **\n", testName);
        }
    }

    // Test Methods

    private boolean testParent(MaxHeap<Integer> heap, Integer input, Integer expectedIndex, Result expectedResult) {

        Result result;

        try {

            Integer output = heap.parent(input);

            if (output.equals(expectedIndex)) {
                result = Result.MatchingValue;
            } else {
                result = Result.Fail;
            }

        } catch (IndexOutOfBoundsException e) {

            result = Result.IndexOutOfBounds;

        } catch (Exception e) {
            System.out.printf("testParent caught unexpected %s\n", e.toString());
            e.printStackTrace();
            result = Result.UnexpectedException;
        }

        return result == expectedResult;

    }

    private boolean testLeftChild(MaxHeap<Integer> heap, Integer input, Integer expectedIndex, Result expectedResult) {

        Result result;

        try {

            Integer output = heap.leftChild(input);

            if (output.equals(expectedIndex)) {
                result = Result.MatchingValue;
            } else {
                result = Result.Fail;
            }

        } catch (IndexOutOfBoundsException e) {

            result = Result.IndexOutOfBounds;

        } catch (Exception e) {
            System.out.printf("testLeftChild caught unexpected %s\n", e.toString());
            e.printStackTrace();
            result = Result.UnexpectedException;
        }

        return result == expectedResult;

    }

    private boolean testRightChild(MaxHeap<Integer> heap, Integer input, Integer expectedIndex, Result expectedResult) {

        Result result;

        try {

            Integer output = heap.rightChild(input);

            if (output.equals(expectedIndex)) {
                result = Result.MatchingValue;
            } else {
                result = Result.Fail;
            }

        } catch (IndexOutOfBoundsException e) {

            result = Result.IndexOutOfBounds;

        } catch (Exception e) {
            System.out.printf("testRightChild caught unexpected %s\n", e.toString());
            e.printStackTrace();
            result = Result.UnexpectedException;
        }

        return result == expectedResult;

    }

    private boolean testSwap(MaxHeap<Integer> heap, Integer firstPosition, Integer secondPosition, Result expectedResult) {

        Result result;

        try {

            heap.swap(firstPosition, secondPosition);
            result = Result.NoException;

        } catch (IndexOutOfBoundsException e) {

            result = Result.IndexOutOfBounds;

        } catch (Exception e) {
            System.out.printf("testSwap caught unexpected %s\n", e.toString());
            e.printStackTrace();
            result = Result.UnexpectedException;
        }

        return result == expectedResult;

    }

    private boolean testMaxHeapify(MaxHeap<Integer> heap, Integer position, Result ExpectedResult) {

        Result result;

        try {

            heap.maxHeapify(heap, position);

        }

    }

}
