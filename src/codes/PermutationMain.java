
public class PermutationMain {

    public static void main(String[] args) {
        int[] arr = {3,4,7};

        int n = arr.length;
        int[] indexes = new int[n];
        permutation("ABC");
        
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

        if (l == r)
            System.out.println(str);
        else
            for(int i = l; i < str.length(); i++){

                str =  swapChar(str, l ,i);
                //System.out.println(str);
                strPermutations(str,l+1,r);
                str = swapChar(str,l,i);
            }
    }

    static String swapChar(String str,int x, int z){
        char[]c = str.toCharArray();
        char temp = c[x];
        c[x]  =    c[z];
        c[z]  =    temp;

        return String.valueOf(c);
    }
    static void permutation(String str) {
        permutation(str, "");
    }
    static void permutation(String str, String prefix) {
        if (str.length() == 0)
            System.out.println(prefix);
        else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
    static void recursivePermutation(char[] ch, int currentIndex) {
        if (currentIndex == ch.length - 1)
            System.out.println(String.valueOf(ch));
        
        for (int i = currentIndex; i < ch.length; i++) {
            charSwap(ch, currentIndex, i);
            recursivePermutation(ch, currentIndex + 1);
            charSwap(ch, currentIndex, i);
        }
    }
    static void charSwap(char[]chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
