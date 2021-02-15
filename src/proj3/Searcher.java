//****************************************************************************************
// CLASS: Searcher (Searcher.java)
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

public class Searcher {
    public static int search(ArrayList<Student> pList, String pKey){
        int low = 0, high = pList.size() - 1;
        while (low <= high){
            int middle = (low + high) / 2;
            if (pKey.equals(pList.get(middle).getLastName())){
                return middle;
            }
            else if (pKey.compareTo(pList.get(middle).getLastName()) < 0){
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return -1; // Not found
    }
}
