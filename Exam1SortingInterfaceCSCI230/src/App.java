public class App {
    public static void main(String[] args) throws Exception {
        // ----------------------  SETUP ------------------------------------------
        Array tester = new Array(3);
        int size = 0;
        tester.add(10);
        // tester.add(3);
        // tester.add(5);
        // tester.add(10);
        // tester.add(16);
        // tester.add(2);
        // tester.print();

        // tester.delete(2);
        // tester.print();


        // ------------------ BINARY SEARCH ALGORITHM TESTS -----------------------

        int find1 = tester.binarySearchIterative(10);
        int find2 = tester.binarySearchIterative(4);
        int find3 = tester.binarySearchIterative(3);
        int find4 = tester.binarySearchIterative(1);
        System.out.println("ITERATIVE BINARY SEARCH: " + find1 + " " + find2 + " " + find3 + " " + find4);

        int find01 = tester.binarySearchRecursive(0, size -1, 3);
        int find02 = tester.binarySearchRecursive(0, size -1, 16);
        int find03 = tester.binarySearchRecursive(0, size -1, 6);
        System.out.println("RECURSIVE BINARY SERACH: " + find01 + " " + find02 + " " + find03);

        // -----------------  SIMPLE SORTING ALGORITHM TESTS ----------------------
        
        System.out.println("SELECTION SORT: ");
        tester.selectionSort();
        tester.print();
        
        System.out.println("\nINSERTION SORT SHIFT: ");
        tester.insertionSortShift();
        tester.print();

        System.out.println("\nINSERTION SORT SWAP: ");
        tester.insertionSortSwap();
        tester.print();

        System.out.println("\nBUBBLE SORT: ");
        tester.bubbleSort();
        tester.print();
    }
}
