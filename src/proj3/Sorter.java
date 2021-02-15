//****************************************************************************************
// CLASS: Sorter (Sorter.java)
//
// DESCRIPTION
// A description of the contents of this file.
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

    private static void quickSort(ArrayList<Student> pList, int pFromIdx, int pToIdx){
        if (pFromIdx >= pToIdx){
            return;
        }
        int partitionIndex = partition(pList, pFromIdx, pToIdx);
        quickSort(pList, pFromIdx, partitionIndex);
        quickSort(pList, partitionIndex + 1, pToIdx);
    } // End quickSort()

    public static void sort(ArrayList<Student> pList){
        quickSort(pList, 0, pList.size() - 1);
    } // End sort()

    private static void swap(ArrayList<Student> pList, int pIdx1, int pIdx2){
        Student temp = pList.get(pIdx1);
        pList.set(pIdx1, pList.get(pIdx2));
        pList.set(pIdx2, temp);
    } // End swap()
}
