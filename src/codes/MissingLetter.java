package codes;

import java.util.Arrays;

public class MissingLetter {

    public static void main(String[] args) {
        char[] arr = {'O','Q','R','S'};
        //char[] arr = {'a','b','c','d','f'};
        System.out.println(findMissingLetter(arr));
        System.out.println(findMissingLetter1(arr));
        System.out.println(findMissingLetter2(arr));
        System.out.println(findMissingLetter3(arr));
    }

    public static char findMissingLetter(char[] array)
    {
        int[]arr = new int[array.length];
        //System.out.print((char)(15+'A'));
        char a = Character.isUpperCase(array[0]) ? 'A' :'a';
        //for(char c : array){
        for(int i = 0;i<array.length; i ++){
           // c = Character.toLowerCase(c);
            System.out.print(array[i]- a +" ");
            arr[i] = array[i] - a;
        }
        Arrays.stream(arr).forEach(x -> System.out.print(" "+x));
        int val = arr[0];
        for(int i = 0;i<arr.length; i ++){
            if(arr[i] == val)
                val++;
            else
                return (char)(val + a);
        }
        return ' ';
    }

    public static char findMissingLetter1(char[] array)
    {
        for (int i = 1; i < array.length ; i++){
            if(array[i] - array[i-1] != 1){
                return (char)(array[i-1]+1);
            }
        }
        throw new IllegalArgumentException("Should not happen!");
    }

    public static char findMissingLetter2(char[] a)
    {
        for(int i = 0; i < a.length; i++){
            if((int)a[i+1] != (int)a[i]+1){
                return (char)(((int)a[i])+1);
            }
        }
        return ' ';
    }

    public static char findMissingLetter3(char[] array) {

        char start = array[0];
        for (char c: array) {
            if (start != c) return start;
            start++;
        }
        return ' ';
    }
}
