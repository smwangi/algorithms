package codes;

import java.util.HashSet;

import java.util.*;

public class UniqueLettersSet{

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter string..");
        String input = scan.nextLine();

        scan.close();

        if(isUnique(input)){
            System.out.println("All xters are unique");
        }else{
            System.out.println("All xters are not unique");
        }

        if(isUniqueArrSort(input)){
            System.out.println("All xters are unique (Array Sort)");
        }else{
            System.out.println("All xters are not unique (Array Sort)");
        }
        
    }

    private static boolean isUniqueArrSort(String input){
        char[] chArr = input.toCharArray();
        Arrays.sort(chArr);

        for(int i = 0; i< chArr.length-1;i++){
            if(chArr[i] != chArr[i+1]){
                continue;
            }else{
                return false;
            }
            
        }
        return true;
    }

    private static boolean isUnique(String str){
        Set<Character> set = new HashSet<>();

        char[] chArr = str.toCharArray();

        for(Character c : chArr){

            if(!set.add(c))
                return false;
        }
        return true;
    }
}