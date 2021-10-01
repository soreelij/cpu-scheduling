import java.util.NoSuchElementException;

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
//  public static final Integer ELEMENT_F = 6;
//  public static final Integer ELEMENT_G = 7;

    private static final Integer MIN = 1;
    private static final Integer MAX = 100;
    private static final Integer RANGE = MAX - MIN + 1;

    public static final Integer SIZE_A = 10;
    public static final Integer SIZE_B = 25;

    private Integer passes = 0;
    private Integer fails = 0;
    private Integer totalTests = 0;

    public static void main(String[] args) {
        MaxHeapTester tester = new MaxHeapTester();
    }

    public MaxHeapTester() {
        runTests();
    }

    private void printTest(String description, boolean result) {

        totalTests++;

        if (result) {

            passes++;
            System.out.printf("TEST: " + description + " passed");

        } else {

            fails++;
            System.out.printf("TEST: " + description + " **FAILED**");

        }

        System.out.printf("\n");


    }

    private void printSummary() {

        String summary = String.format("\nTotal tests: %d | Passed: %d | Failed: %d\n",
                totalTests, passes, fails);

        System.out.printf(summary);

    }

    private void runTests() {

        System.out.println("PASS 1: HEAP OPERATIONS");
        System.out.println("***********************");

        testEmptyHeap("emptyHeap");
        testEmptyHeap_Insert_A("emptyHeap_insert_A_A ");
        testA_insert_B("A_insert_B_BA");
        testBA_insert_C_CAB("BA_insert_C_CBA");
        test_CAB_insert_D_DCBA("CAB_insert_D_DCBA");

        printSummary();

        // TODO: Add second pass of tests with random values and check if they are valid heaps

        System.out.println("PASS 2: VALID HEAPS AT VARYING SIZES");
        System.out.println("***********************");
        test_randomHeap_10_5("randomHeap_10_5");

    }

    // Base Heaps

    // no heap -> []
    private MaxHeap<Integer> newHeap() {
        return new MaxHeap<Integer>();
    }

    // [] -> insert(A) -> [A]
    private MaxHeap<Integer> emptyHeap_Insert_A() {

        MaxHeap<Integer> heap = newHeap();
        heap.insert(ELEMENT_A);
        return heap;

    }

    // [A] -> insert(B) -> [B,A]
    private MaxHeap<Integer> A_insert_B() {

        MaxHeap<Integer> heap = emptyHeap_Insert_A();
        heap.insert(ELEMENT_B);
        return heap;

    }

    // [B,A] -> insert(C) -> [C,B,A]
    private MaxHeap<Integer> BA_insert_C() {

        MaxHeap<Integer> heap = A_insert_B();
        heap.insert(ELEMENT_C);
        return heap;

    }

    // [C,A,B] -> insert(D) -> [D,C,B,A]
    private MaxHeap<Integer> CAB_insert_D() {

        MaxHeap<Integer> heap = BA_insert_C();
        heap.insert(ELEMENT_D);
        return heap;

    }

    // Random heap of size 10 with 10 random elements
    private MaxHeap<Integer> randomHeap_10() {

        MaxHeap<Integer> heap = newHeap();

        for (int i = 0; i < 10; i++) {

            int nextValue =  (int) (Math.random() * RANGE) + MIN;
            heap.insert(nextValue);

        }

        return heap;

    }
    // Tests

    // Empty Heap []
    private void testEmptyHeap(String testName) {
        System.out.printf("\nTEST: %s\n", testName);
        System.out.println("***********************");
        try {

            // parent
            printTest(testName + "_parent(-1)", testParent(newHeap(), -1, null, Result.IndexOutOfBounds));
            printTest(testName + "_parent(0)", testParent(newHeap(), 0, null, Result.IndexOutOfBounds));
            printTest(testName + "_parent(1)", testParent(newHeap(), 1, null, Result.IndexOutOfBounds));

            // leftChild
            printTest(testName + "_leftChild(-1)", testLeftChild(newHeap(), -1, null, Result.IndexOutOfBounds));
            printTest(testName + "_leftChild(0)", testLeftChild(newHeap(), 0, null, Result.IndexOutOfBounds));
            printTest(testName + "_leftChild(1)", testLeftChild(newHeap(), 1, null, Result.IndexOutOfBounds));

            // rightChild
            printTest(testName + "_rightChild(-1)", testRightChild(newHeap(),-1, null, Result.IndexOutOfBounds));
            printTest(testName + "_rightChild(0)", testRightChild(newHeap(),0, null, Result.IndexOutOfBounds));
            printTest(testName + "_rightChild(-1)", testRightChild(newHeap(),1, null, Result.IndexOutOfBounds));

            // swap
            printTest(testName + "_swap(-1, 0)", testSwap(newHeap(), -1, 0, Result.IndexOutOfBounds));
            printTest(testName + "_swap(0, 1)", testSwap(newHeap(), 0, 1, Result.IndexOutOfBounds));

            // maxHeapify
            printTest(testName + "_maxHeapify(0)", testMaxHeapify(newHeap(), 0, Result.IndexOutOfBounds));

            // insert
            printTest(testName + "_insert(A)", testInsert(newHeap(), ELEMENT_A, Result.NoException));

            // ExtractMax
            printTest(testName + "_extractMax()", testExtractMax(newHeap(), null, Result.NoSuchElement));

            // isEmpty
            printTest(testName + "_isEmpty()", testIsEmpty(newHeap(), true, Result.Pass));

            // size
            printTest(testName + "_size", testSize(newHeap(), 0, Result.Pass));

            // toString
            printTest(testName + "_toString()", testToString(newHeap(), "[]", Result.MatchingValue));

        } catch (Exception e) {

            System.out.printf("** UNABLE TO COMPLETE %s TESTS **\n", testName);

        }
    }

    // [] -> insert(A) -> [A]
    private void testEmptyHeap_Insert_A(String testName) {
        System.out.printf("\nTEST: %s\n", testName);
        System.out.println("***********************");
        try {

            // parent
            printTest(testName + "_parent(0)", testParent(emptyHeap_Insert_A(), 0, null, Result.IndexOutOfBounds));
            printTest(testName + "_parent(1)", testParent(emptyHeap_Insert_A(), 1, 0, Result.MatchingValue));
            printTest(testName + "_parent(2)", testParent(emptyHeap_Insert_A(), 2, null, Result.IndexOutOfBounds));

            // leftChild
            printTest(testName + "_leftChild(0)", testLeftChild(emptyHeap_Insert_A(), 0, null, Result.IndexOutOfBounds));
            printTest(testName + "_leftChild(1)", testLeftChild(emptyHeap_Insert_A(), 1, 2, Result.MatchingValue));
            printTest(testName + "_leftChild(2)", testLeftChild(emptyHeap_Insert_A(), 2, null, Result.IndexOutOfBounds));

            // rightChild
            printTest(testName + "_rightChild(0)", testRightChild(emptyHeap_Insert_A(),0, null, Result.IndexOutOfBounds));
            printTest(testName + "_rightChild(1)", testRightChild(emptyHeap_Insert_A(),1, 3, Result.MatchingValue));
            printTest(testName + "_rightChild(2)", testRightChild(emptyHeap_Insert_A(),2, null, Result.IndexOutOfBounds));

            // swap
            printTest(testName + "_swap(-1, 0)", testSwap(emptyHeap_Insert_A(), -1, 0, Result.IndexOutOfBounds));
            printTest(testName + "_swap(0, 1)", testSwap(emptyHeap_Insert_A(), 0, 1, Result.IndexOutOfBounds));

            // maxHeapify
            printTest(testName + "_maxHeapify(0)", testMaxHeapify(emptyHeap_Insert_A(), 0, Result.IndexOutOfBounds));
            printTest(testName + "_maxHeapify(1)", testMaxHeapify(emptyHeap_Insert_A(), 1, Result.NoException));

            // insert
            printTest(testName + "_insert(B)", testInsert(emptyHeap_Insert_A(), ELEMENT_B, Result.NoException));

            // ExtractMax
            printTest(testName + "_extractMax()", testExtractMax(emptyHeap_Insert_A(), ELEMENT_A, Result.MatchingValue));

            // isEmpty
            printTest(testName + "_isEmpty()", testIsEmpty(emptyHeap_Insert_A(), false, Result.Pass));

            // size
            printTest(testName + "_size", testSize(emptyHeap_Insert_A(), 1, Result.Pass));

            // toString
            printTest(testName + "_toString()", testToString(emptyHeap_Insert_A(), "[1]", Result.MatchingValue));

        } catch (Exception e) {

            System.out.printf("** UNABLE TO COMPLETE %s TESTS **\n", testName);

        }
    }

    // [B] -> insert(B) [B,A]
    private void testA_insert_B(String testName) {
        System.out.printf("\nTEST: %s\n", testName);
        System.out.println("***********************");
        try {

            // parent
            printTest(testName + "_parent(0)", testParent(A_insert_B(), 0, null, Result.IndexOutOfBounds));
            printTest(testName + "_parent(1)", testParent(A_insert_B(), 1, 0, Result.MatchingValue));
            printTest(testName + "_parent(2)", testParent(A_insert_B(), 2, 1, Result.MatchingValue));
            printTest(testName + "_parent(3)", testParent(A_insert_B(), 3, null, Result.IndexOutOfBounds));

            // leftChild
            printTest(testName + "_leftChild(0)", testLeftChild(A_insert_B(), 0, null, Result.IndexOutOfBounds));
            printTest(testName + "_leftChild(1)", testLeftChild(A_insert_B(), 1, 2, Result.MatchingValue));
            printTest(testName + "_leftChild(2)", testLeftChild(A_insert_B(), 2, 4, Result.MatchingValue));
            printTest(testName + "_leftChild(3)", testLeftChild(A_insert_B(), 3, null, Result.IndexOutOfBounds));

            // rightChild
            printTest(testName + "_rightChild(0)", testRightChild(A_insert_B(),0, null, Result.IndexOutOfBounds));
            printTest(testName + "_rightChild(1)", testRightChild(A_insert_B(),1, 3, Result.MatchingValue));
            printTest(testName + "_rightChild(2)", testRightChild(A_insert_B(),2, 5, Result.MatchingValue));
            printTest(testName + "_rightChild(3)", testRightChild(A_insert_B(),3, null, Result.IndexOutOfBounds));

            // swap
            printTest(testName + "_swap(0, 1)", testSwap(A_insert_B(), 0, 1, Result.IndexOutOfBounds));
            printTest(testName + "_swap(1, 2)", testSwap(A_insert_B(), 1, 2, Result.NoException));
            printTest(testName + "_swap(2,3)", testSwap(A_insert_B(), 2, 3, Result.IndexOutOfBounds));

            // maxHeapify
            printTest(testName + "_maxHeapify(0)", testMaxHeapify(A_insert_B(), 0, Result.IndexOutOfBounds));
            printTest(testName + "_maxHeapify(1)", testMaxHeapify(A_insert_B(), 1, Result.NoException));
            printTest(testName + "_maxHeapify(2)", testMaxHeapify(A_insert_B(), 2, Result.NoException));
            printTest(testName + "_maxHeapify(3)", testMaxHeapify(A_insert_B(), 3, Result.IndexOutOfBounds));

            // insert
            printTest(testName + "_insert(C)", testInsert(A_insert_B(), ELEMENT_C, Result.NoException));

            // ExtractMax
            printTest(testName + "_extractMax()", testExtractMax(A_insert_B(), ELEMENT_B, Result.MatchingValue));

            // isEmpty
            printTest(testName + "_isEmpty()", testIsEmpty(A_insert_B(), false, Result.Pass));

            // size
            printTest(testName + "_size", testSize(A_insert_B(), 2, Result.Pass));

            // toString
            printTest(testName + "_toString()", testToString(A_insert_B(), "[2,1]", Result.MatchingValue));

        } catch (Exception e) {

            System.out.printf("** UNABLE TO COMPLETE %s TESTS **\n", testName);

        }
    }

    private void testBA_insert_C_CAB(String testName) {

        System.out.printf("\nTEST: %s\n", testName);
        System.out.println("***********************");

        try {

            // parent
            printTest(testName + "_parent(0)", testParent(BA_insert_C(), 0, null, Result.IndexOutOfBounds));
            printTest(testName + "_parent(1)", testParent(BA_insert_C(), 1, 0, Result.MatchingValue));
            printTest(testName + "_parent(2)", testParent(BA_insert_C(), 2, 1, Result.MatchingValue));
            printTest(testName + "_parent(3)", testParent(BA_insert_C(), 3, 1, Result.MatchingValue));
            printTest(testName + "_parent(4)", testParent(BA_insert_C(), 4, null, Result.IndexOutOfBounds));

            // leftChild
            printTest(testName + "_leftChild(0)", testLeftChild(BA_insert_C(), 0, null, Result.IndexOutOfBounds));
            printTest(testName + "_leftChild(1)", testLeftChild(BA_insert_C(), 1, 2, Result.MatchingValue));
            printTest(testName + "_leftChild(2)", testLeftChild(BA_insert_C(), 2, 4, Result.MatchingValue));
            printTest(testName + "_leftChild(3)", testLeftChild(BA_insert_C(), 3, 6, Result.MatchingValue));
            printTest(testName + "_leftChild(4)", testLeftChild(BA_insert_C(), 4, null, Result.IndexOutOfBounds));

            // rightChild
            printTest(testName + "_rightChild(0)", testRightChild(BA_insert_C(),0, null, Result.IndexOutOfBounds));
            printTest(testName + "_rightChild(1)", testRightChild(BA_insert_C(),1, 3, Result.MatchingValue));
            printTest(testName + "_rightChild(2)", testRightChild(BA_insert_C(),2, 5, Result.MatchingValue));
            printTest(testName + "_rightChild(3)", testRightChild(BA_insert_C(),3, 7, Result.MatchingValue));
            printTest(testName + "_rightChild(4)", testRightChild(BA_insert_C(),4, null, Result.IndexOutOfBounds));

            // swap
            printTest(testName + "_swap(0, 1)", testSwap(BA_insert_C(), 0, 1, Result.IndexOutOfBounds));
            printTest(testName + "_swap(1,2)", testSwap(BA_insert_C(), 1, 2, Result.NoException));
            printTest(testName + "_swap(2, 3)", testSwap(BA_insert_C(), 2, 3, Result.NoException));
            printTest(testName + "_swap(3, 4)", testSwap(BA_insert_C(), 3, 4, Result.IndexOutOfBounds));

            // maxHeapify
            printTest(testName + "_maxHeapify(0)", testMaxHeapify(BA_insert_C(), 0, Result.IndexOutOfBounds));
            printTest(testName + "_maxHeapify(1)", testMaxHeapify(BA_insert_C(), 1, Result.NoException));
            printTest(testName + "_maxHeapify(2)", testMaxHeapify(BA_insert_C(), 2, Result.NoException));
            printTest(testName + "_maxHeapify(3)", testMaxHeapify(BA_insert_C(), 3, Result.NoException));
            printTest(testName + "_maxHeapify(4)", testMaxHeapify(BA_insert_C(), 4, Result.IndexOutOfBounds));

            // insert
            printTest(testName + "_insert(D)", testInsert(BA_insert_C(), ELEMENT_D, Result.NoException));

            // ExtractMax
            printTest(testName + "_extractMax()", testExtractMax(BA_insert_C(), ELEMENT_C, Result.MatchingValue));

            // isEmpty
            printTest(testName + "_isEmpty()", testIsEmpty(BA_insert_C(), false, Result.Pass));

            // size
            printTest(testName + "_size", testSize(BA_insert_C(), 3, Result.Pass));

            // toString
            printTest(testName + "_toString()", testToString(BA_insert_C(), "[3,1,2]", Result.MatchingValue));


        } catch (Exception e) {

            System.out.printf("** UNABLE TO COMPLETE %s TESTS **\n", testName);

        }

    }

    private void test_CAB_insert_D_DCBA(String testName) {

        System.out.printf("\nTEST: %s\n", testName);
        System.out.println("***********************");

        try {

            // parent
            printTest(testName + "_parent(0)", testParent(CAB_insert_D(), 0, null, Result.IndexOutOfBounds));
            printTest(testName + "_parent(1)", testParent(CAB_insert_D(), 1, 0, Result.MatchingValue));
            printTest(testName + "_parent(2)", testParent(CAB_insert_D(), 2, 1, Result.MatchingValue));
            printTest(testName + "_parent(3)", testParent(CAB_insert_D(), 3, 1, Result.MatchingValue));
            printTest(testName + "_parent(4)", testParent(CAB_insert_D(), 4, 2, Result.MatchingValue));
            printTest(testName + "_parent(5)", testParent(CAB_insert_D(), 5, null, Result.IndexOutOfBounds));

            // leftChild
            printTest(testName + "_leftChild(0)", testLeftChild(CAB_insert_D(), 0, null, Result.IndexOutOfBounds));
            printTest(testName + "_leftChild(1)", testLeftChild(CAB_insert_D(), 1, 2, Result.MatchingValue));
            printTest(testName + "_leftChild(2)", testLeftChild(CAB_insert_D(), 2, 4, Result.MatchingValue));
            printTest(testName + "_leftChild(3)", testLeftChild(CAB_insert_D(), 3, 6, Result.MatchingValue));
            printTest(testName + "_leftChild(4)", testLeftChild(CAB_insert_D(), 4, 8, Result.MatchingValue));
            printTest(testName + "_leftChild(5)", testLeftChild(CAB_insert_D(), 5, null, Result.IndexOutOfBounds));

            // rightChild
            printTest(testName + "_rightChild(0)", testRightChild(CAB_insert_D(),0, null, Result.IndexOutOfBounds));
            printTest(testName + "_rightChild(1)", testRightChild(CAB_insert_D(),1, 3, Result.MatchingValue));
            printTest(testName + "_rightChild(2)", testRightChild(CAB_insert_D(),2, 5, Result.MatchingValue));
            printTest(testName + "_rightChild(3)", testRightChild(CAB_insert_D(),3, 7, Result.MatchingValue));
            printTest(testName + "_rightChild(4)", testRightChild(CAB_insert_D(),4, 9, Result.MatchingValue));
            printTest(testName + "_rightChild(5)", testRightChild(CAB_insert_D(),5, null, Result.IndexOutOfBounds));

            // swap
            printTest(testName + "_swap(0, 1)", testSwap(CAB_insert_D(), 0, 1, Result.IndexOutOfBounds));
            printTest(testName + "_swap(1,2)", testSwap(CAB_insert_D(), 1, 2, Result.NoException));
            printTest(testName + "_swap(2, 3)", testSwap(CAB_insert_D(), 2, 3, Result.NoException));
            printTest(testName + "_swap(3, 4)", testSwap(CAB_insert_D(), 3, 4, Result.NoException));
            printTest(testName + "_swap(4, 5)", testSwap(CAB_insert_D(), 4, 5, Result.IndexOutOfBounds));

            // maxHeapify
            printTest(testName + "_maxHeapify(0)", testMaxHeapify(CAB_insert_D(), 0, Result.IndexOutOfBounds));
            printTest(testName + "_maxHeapify(1)", testMaxHeapify(CAB_insert_D(), 1, Result.NoException));
            printTest(testName + "_maxHeapify(2)", testMaxHeapify(CAB_insert_D(), 2, Result.NoException));
            printTest(testName + "_maxHeapify(3)", testMaxHeapify(CAB_insert_D(), 3, Result.NoException));
            printTest(testName + "_maxHeapify(4)", testMaxHeapify(CAB_insert_D(), 4, Result.NoException));
            printTest(testName + "_maxHeapify(5)", testMaxHeapify(CAB_insert_D(), 5, Result.IndexOutOfBounds));

            // insert
            printTest(testName + "_insert(E)", testInsert(CAB_insert_D(), ELEMENT_E, Result.NoException));

            // ExtractMax
            printTest(testName + "_extractMax()", testExtractMax(CAB_insert_D(), ELEMENT_D, Result.MatchingValue));

            // isEmpty
            printTest(testName + "_isEmpty()", testIsEmpty(CAB_insert_D(), false, Result.Pass));

            // size
            printTest(testName + "_size", testSize(CAB_insert_D(), 4, Result.Pass));

            // toString
            printTest(testName + "_toString()", testToString(CAB_insert_D(), "[4,3,2,1]", Result.MatchingValue));

        } catch (Exception e) {

            System.out.printf("** UNABLE TO COMPLETE %s TESTS **\n", testName);

        }

    }

    private void test_randomHeap_10_5(String testName) {

        System.out.printf("\nTEST: %s\n", testName);
        System.out.println("***********************");

        for (int i = 0; i < 5; i++) {

            System.out.println("------------------------------");
            System.out.println("Random Heap " + (i + 1) + "/5");
            System.out.println(randomHeap_10().toString());
        }


    }

    // Test Methods

    // PASS 1
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

    private boolean testMaxHeapify(MaxHeap<Integer> heap, Integer position, Result expectedResult) {

        Result result;

        try {

            heap.maxHeapify(position);
            result = Result.NoException;

        } catch (IndexOutOfBoundsException e) {

            result = Result.IndexOutOfBounds;

        } catch (Exception e) {
            System.out.printf("testMaxHeapify caught unexpected %s\n", e.toString());
            e.printStackTrace();
            result = Result.UnexpectedException;
        }

        return result == expectedResult;

    }

    private boolean testInsert(MaxHeap<Integer> heap, Integer element, Result expectedResult) {

        Result result;

        try {

            heap.insert(element);
            result = Result.NoException;

        } catch (IndexOutOfBoundsException e) {

            result = Result.IndexOutOfBounds;

        } catch (Exception e) {

            System.out.printf("testMaxHeapify caught unexpected %s\n", e.toString());
            e.printStackTrace();
            result = Result.UnexpectedException;

        }

        return result == expectedResult;

    }

    private boolean testExtractMax(MaxHeap<Integer> heap, Integer expectedValue, Result expectedResult) {

        Result result;

        try {

            Integer output = heap.extractMax();

            if(output == expectedValue) {

                result = Result.MatchingValue;

            } else {

                result = Result.Fail;

            }

        } catch (NoSuchElementException e) {

            result = Result.NoSuchElement;

        } catch (Exception e) {

            System.out.printf("testExtractMax caught unexpected %s\n", e.toString());
            e.printStackTrace();
            result = Result.UnexpectedException;

        }

        return result == expectedResult;

    }

    private boolean testIsEmpty(MaxHeap<Integer> heap, boolean expectedValue, Result expectedResult) {

        Result result;

        try {

            boolean output = heap.isEmpty();

            if (output == expectedValue) {

                result = Result.Pass;

            } else {

                result = Result.Fail;

            }

        } catch (Exception e) {

            System.out.printf("testExtractMax caught unexpected %s\n", e.toString());
            e.printStackTrace();
            result = Result.UnexpectedException;

        }

        return result == expectedResult;

    }

    private boolean testSize(MaxHeap<Integer> heap, Integer expectedValue, Result expectedResult) {

        Result result;

        try {

            Integer output = heap.size();

            if (output.equals(expectedValue)) {

                result = Result.Pass;

            } else {

                result = Result.Fail;

            }

        } catch (Exception e) {

            System.out.printf("testExtractMax caught unexpected %s\n", e.toString());
            e.printStackTrace();
            result = Result.UnexpectedException;

        }

        return result == expectedResult;

    }

    private boolean testToString(MaxHeap<Integer> heap, String expectedString, Result expectedResult) {

        Result result;

        try {

            String output = heap.toString();
            System.out.printf("toString() output: %s\n", output);

            if (output.compareTo(expectedString) == 0) {

                result = Result.MatchingValue;

            } else {

                result = Result.Fail;

            }

        } catch (Exception e) {

            System.out.printf("testExtractMax caught unexpected %s\n", e.toString());
            e.printStackTrace();
            result = Result.UnexpectedException;

        }

        return result == expectedResult;

    }

    // PASS 2
//    private boolean testValidMaxHeap(MaxHeap<Integer> heap, Result expectedResult) {
//
//        Result result = Result.Pass;
//
//        try {
//
//            Integer maximum = heap.extractMax();
//            Integer lastValue;
//
//            for (int i = heap.size(); i > 0; i--) {
//
//                lastValue = heap.extractMax();
//
//                if (heap.extractMax().compareTo(maximum) >= 0) {
//
//                    result = Result.Fail;
//
//                }
//
//            }
//
//        } catch (Exception e) {
//
//            System.out.printf("testExtractMax caught unexpected %s\n", e.toString());
//            e.printStackTrace();
//            result = Result.UnexpectedException;
//
//        }
//
//        return result == expectedResult;
//
//    }

}
