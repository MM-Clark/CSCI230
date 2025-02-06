import java.util.Scanner;

public class Array {
    
    private int[] a;
    private int size;
    private Scanner keyboard = new Scanner(System.in);
    
    public Array(int max)
    {
        size = 0;
        a = new int[max];
    }

    public void add(int num)
    {
        if(size<a.length)
        {
            a[size] = num;
            size++;
        }
        else
            System.out.println("Cannot add. Array full.");
    }

    public void delete(int idx)
    {
        if(size>0)
        {
            for(int i=size-1; i>idx; i--)
                a[i-1] = a[i];
            size--;
        }
        else
            System.out.println("Can't delete. Empty array.");
    }

    public void print()
    {
        for(int i=0; i < size; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public int linearSearch(int num)
    {
        for(int i=0; i<size; i++)
        {
            if(a[i] == num)
                return i;
        }
        return -1; // never found
    }

    public int binarySearchIterative(int key)
    {
        int low = 0;
        int high = size - 1;
        int mid = 0;

        while(low <= high)
        {
            mid = (low + high)/2;
            if(a[mid] < key)
                low = mid + 1;
            else if(a[mid] > key)
                high = mid - 1;
            else
                return mid;
        }

        return -1;
    }

    public int binarySearchRecursive(int low, int high, int key)
    {
        if(low > high)
            return -1; 
        int mid = (low + high)/2;
        if(a[mid] < key)
            return binarySearchRecursive(mid + 1, high, key);
        else if(a[mid] > key)
            return binarySearchRecursive(low, mid - 1, key);
        else
            return mid;
    }

    public void swap(int swapOne, int swapTwo)
    {
        int temp = a[swapOne];
        a[swapOne] = a[swapTwo];
        a[swapTwo] = temp;
    }

    public void bubbleSort()
    {
        for(int i=size-1; i>0; i--)
        {
            for(int j=0; j<i; j++)
                if(a[j] > a[j+1])
                    swap(j, j+1);

            System.out.println("Iteration " + (size-1-i) + ": ");
            print();
        }
    }

    public void selectionSort()
    {
        for(int i=0; i<size-1; i++)
        {
            int smallestIdx = i;
            for(int j = i + 1; j < size; j++)
                if(a[j] < a[smallestIdx])
                    smallestIdx = j;
            
            System.out.println("Iteration " + i + ": ");
            print();

            swap(i, smallestIdx);
        }
    }

    public void insertionSortShift()
    {
        for(int i=1; i < size; i++)
        {
            int j = i - 1;
            int key = a[i];
            while(j >= 0 && a[j] > key)
            {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;

            System.out.println("Iteration " + i + ": ");
            print();
        }
    }

    public void insertionSortSwap()
    {
        for(int i=1; i < size; i++)
        {
            int j = i;
            while(j > 0 && a[j] < a[j - 1])
            {
                swap(j, j-1);
                j--;
            }
            
            System.out.println("Iteration " + i + ": ");
            print();
        }
    }
}
