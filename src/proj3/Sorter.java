//****************************************************************************************
// CLASS: Sorter (Sorter.java)
//
// DESCRIPTION
// Implements a quick sort algorithm to sort the elements in an ArrayList<Student> in ascending order by last name
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring 2021
// Project Number: 3
//
// AUTHORS
// Teodoro Salgado, tjsalgad, tsalgado96@gmail.com
// Isaac Pena, ipena5, ippenaisaac@gmail.com
// Stephen Elledge, saelledg, saelledg@asu.edu
// ****************************************************************************************
package proj3;

import java.util.ArrayList;

public class Sorter {
    /**
     * Partitions a sublist where the all the elements in the left list are
     * less than all the elements in the right list
     */
    private static int partition(ArrayList<Student> pList, int pFromIdx, int pToIdx){
        String pivotLastName = pList.get(pFromIdx).getLastName();
        int leftIndex = pFromIdx - 1;
        int rightIndex = pToIdx + 1;
        while (leftIndex < rightIndex){
            leftIndex++;
            while (pList.get(leftIndex).getLastName().compareTo(pivotLastName) < 0){
                leftIndex++;
            }
            rightIndex--;
            while (pList.get(rightIndex).getLastName().compareTo(pivotLastName) > 0){
                rightIndex--;
            }

            if (leftIndex < rightIndex){
                swap(pList, leftIndex, rightIndex);
            }
        }
        return rightIndex;
    } // End partition()

    /**
     * Partition the input list and recursively quick sort the left and right sublist
     */
    private static void quickSort(ArrayList<Student> pList, int pFromIdx, int pToIdx){
        if (pFromIdx >= pToIdx){
            return;
        }
        int partitionIndex = partition(pList, pFromIdx, pToIdx);
        quickSort(pList, pFromIdx, partitionIndex);
        quickSort(pList, partitionIndex + 1, pToIdx);
    } // End quickSort()

    /**
     * Initializes the quick sort algorithm
     */
    public static void sort(ArrayList<Student> pList){
        quickSort(pList, 0, pList.size() - 1);
    } // End sort()

    /**
     * Implements a simple swap between two elements in the ArrayList<Student>
     */
    private static void swap(ArrayList<Student> pList, int pIdx1, int pIdx2){
        Student temp = pList.get(pIdx1);
        pList.set(pIdx1, pList.get(pIdx2));
        pList.set(pIdx2, temp);
    } // End swap()
}
