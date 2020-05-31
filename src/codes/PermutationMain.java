package codes;

import java.util.Arrays;

public class PermutationMain {

    public static void main(String[] args) {
        int[] arr = {3,4,7};

        int n = arr.length;
        int[] indexes = new int[n];

        int i = 0;
        printElements(arr);
        while (i < n){
            //System.out.println("index[i] "+indexes[i]);
            //System.out.println("i main "+i);
            if(indexes[i] < i)
            {
               // System.out.println("i "+i);
                // if size is odd, swap first and last
                // element
                // If size is even, swap ith and last
                // element 
                swap(arr,i % 2 == 0 ? 0 : indexes[i],i);
                printElements(arr);
                indexes[i]++;
                i = 0;
            }else{
                indexes[i]=0;
                i++;
            }
        }
        String s = "ABC";
        strPermutations(s,0,s.length()-1);
        //Arrays.stream(indexes).forEachOrdered(System.out::print);
    }

    static void swap(int[] arr, int i, int j){
        //System.out.println("i "+i+" j "+j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void printElements(int[] arr){
        for (int c : arr)
        {
            System.out.print(c+" ");

        }
        System.out.println();
    }

    static void strPermutations(String str, int l, int r){

        //char[] c = str.toCharArray();
        //int[] indexes = new int[c.length];

        //int i = 0, len = c.length;
        /*while (i < len){

            swap(c,i % 2 == 0 ? 0 : i);
        }*/
        if (l == r)
            System.out.println(str);
        else
            for(int i = l; i < str.length(); i++){

                str =  swapChar(str, l ,i);
                //System.out.println(str);
                strPermutations(str,l+1,r);
                str = swapChar(str,l,i);
                //if(indexes[i] < str.length()){
                   // swapChar(c,i % 2 == 0 ? 0 : indexes[i],i);
                    //Arrays.toString(c);
                    //System.out.println(Arrays.toString(c));
                    //indexes[i]++;
                    //i = 0;

               // }else{
                   // indexes[i] = 0;
                //}

            }
    }

    static String swapChar(String str,int x, int z){
        char[]c = str.toCharArray();
        char temp = c[x];
        c[x]  =    c[z];
        c[z]  =    temp;

        return String.valueOf(c);
    }
}
