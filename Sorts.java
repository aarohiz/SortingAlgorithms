import java.util.*;
import java.util.Arrays. *;
/**
 *  All of the sorting algorithms I have discovered thus far are carefully conserved in this precious class.
 *
 * @author     Aarohi Zade
 * @created    February 28th, 2019
 */
public class Sorts
{
    private long steps;

    /**
     *  Description of Constructor
     *
     * @param  list  Description of Parameter
     */
    Sorts()
    {
        steps = 0;
    }

    /**
     *  Description lof the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void bubbleSort(int[] list)
    {
        for (int outer = 0; outer < list.length - 1; outer++)
        {
            for (int inner = 0; inner < list.length-outer-1; inner++)
            {
                if (list[inner] > list[inner + 1])
                {
                    //swap list[inner] & ist[inner+1]
                    int temp = list[inner];
                    list[inner] = list[inner + 1];
                    list[inner + 1] = temp;
                    steps++;
                }
                steps++;
            }
            steps++;
        }
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println();
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void selectionSort(int[] list)
    {
        int min, temp;
        for (int outer = 0; outer < list.length - 1; outer++)
        {
            min = outer;
            for (int inner = outer + 1; inner < list.length; inner++)
            {
                if (list[inner] < list[min])
                {
                    min = inner;
                    steps++;
                }
                steps++;
            }
            //swap list[outer] & list[flag]
            temp = list[outer];
            list[outer] = list[min];
            list[min] = temp;
            steps++;
        }
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println();
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void insertionSort(int[] list)
    {
        for (int outer = 1; outer < list.length; outer++)
        {
            int position = outer;
            int key = list[position];
            // Shift larger values to the right
            while (position > 0 && list[position - 1] > key)
            {
                list[position] = list[position - 1];
                position--;
                steps++;
            }
            list[position] = key;
            steps++;
        }
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println();
    }

    /**
     *  Takes in entire vector, but will merge the following sections
     *  together:  Left sublist from a[first]..a[mid], right sublist from
     *  a[mid+1]..a[last].  Precondition:  each sublist is already in
     *  ascending order
     *
     * @param  a      reference to an array of integers to be sorted
     * @param  first  starting index of range of values to be sorted
     * @param  mid    midpoint index of range of values to be sorted
     * @param  last   last index of range of values to be sorted
     */
    public void merge(int[] a, int first, int mid, int last)
    {
        
        int[] left = Arrays.copyOfRange(a, first, mid);
        int[] right = Arrays.copyOfRange(a, mid+1, last);
        //splits array into 2
        int leftLen= left.length;
        int rightLen = right.length;
        int[] merge = new int[a.length];
        //finds length of each array and makes a new one
        int i = 0, j = 0, k = 0; //left counter, right counter, merge counter
        while(i < leftLen && j < rightLen)
        {
            if(left[i] < right[j])
            {
               merge[k] = left[i]; 
               k++;
               i++;
            }
            else
            {
                merge[k] = right[j];
                k++;
                j++;
            }
        }
        while(i < leftLen)
        {
            merge[k] = left[i];
            k++;
            i++;
        }
        while(j < rightLen)
        {
            merge[k] = right[j];
            k++;
            j++;
        }
        
    }

    /**
     *  Recursive mergesort of an array of integers
     *
     * @param  a      reference to an array of integers to be sorted
     * @param  first  starting index of range of values to be sorted
     * @param  last   ending index of range of values to be sorted
     */
    public void mergeSort(int[] a, int first, int last)
    {
        if (first < last) {    
            
            // (l+r) but safer for stack overflow
            int mid = first + (last - first) / 2;
            
            // sort first and second halves
            mergeSort(a, first, mid);
            mergeSort(a, mid+1, last);
            
            merge(a, first, mid, last);
            
            
        }
    }

    /**
     *  Recursive quicksort of an array of integers
     *
     * @param  a      reference to an array of integers to be sorted
     * @param  first  starting index of range of values to be sorted
     * @param  last   ending index of range of values to be sorted
     */
    public void quickSort(int[] a, int first, int last)
    {

        int g = first, h = last;

        int midIndex = (first + last) / 2;
        int dividingValue = a[midIndex];
        do
        {
            while (a[g] < dividingValue)
                g++;
            while (a[h] > dividingValue)
                h--;
            if (g <= h)
            {
                //swap(list[g], list[h]);
                int temp = a[g];
                a[g] = a[h];
                a[h] = temp;
                g++;
                h--;
                steps++;
            }
        }
        while (g < h);

        if (h > first)
        {
            quickSort (a,first,h);
            steps++;
        }
        if (g < last)
        {
            quickSort (a,g,last);
            steps++;
        }
    }

    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount()
    {
        return steps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(int stepCount)
    {
        steps = stepCount;
    }
}