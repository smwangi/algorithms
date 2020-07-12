package codes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Insert y at index x:
 *
 * Insert
 * x y
 * Delete the element at index x:
 *
 * Delete
 * x
 * Given a list, L, of N integers, perform Q queries on the list.
 * Once all queries are completed, print the modified list as a single line of space-separated integers.
 *
 * Input Format
 *
 * The first line contains an integer, N (the initial number of elements in L).
 * The second line contains N space-separated integers describing L.
 * The third line contains an integer, Q (the number of queries).
 * The 2Q subsequent lines describe the queries, and each query is described over two lines:
 *
 * If the first line of a query contains the String Insert, then the second line contains two space separated integers x,y,
 * and the value y must be inserted into L at index x.
 * If the first line of a query contains the String Delete, then the second line contains index , whose element must be deleted from L.
 *
 * Constraints
 * 1 <= N <= 4000
 * 1 <= Q <= 4000
 *
 * Each element in is a 32-bit integer.
 *
 * Output Format
 *
 * Print the updated list L as a single line of space-separated integers.
 *
 * Sample Input
 *
 * 5
 * 12 0 1 78 12
 * 2
 * Insert
 * 5 23
 * Delete
 * 0
 * Sample Output
 *
 * 0 1 78 12 23
 *
 * Explanation
 *
 * L = {12,0,1,78,12}
 *  Insert 23 at index 5.
 * L0 = {12,0,1,78,12,23}
 *  Delete the element at index 0.
 * L0 = {0,1,78,12,23}
 * Having performed all Q queries, we print L1 as a single line of space-separated integers.
 */
public class JavaListHR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        LinkedList<Integer> ls = new LinkedList<>();
        for(int i = 0; i < N; i++){
            int val = in.nextInt();
            ls.add(val);
        }
        int Q = in.nextInt();
        //Queries on LinkedList
        for (int i = 0; i < Q; i++){
            String action = in.next();
            if(action.equals("Insert")){
                int index = in.nextInt();
                int value = in.nextInt();
                ls.add(index,value);
            }else{//Delete
                int index = in.nextInt();
                ls.remove(index);
            }
        }
        in.close();
        ls.forEach(i -> System.out.print(i+" "));

    }
}
