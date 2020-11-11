import java.util.HashMap;
import java.util.Map;

public class SmallestSubStringOfAllCharacters {

    public static void main(String[] args) {

        char[] arr = {'x','y','z'};
        String str = "xyyzyzyx";
        System.out.println(getShortestUniqueSubstring(arr,str));
    }

    static String getShortestUniqueSubstring(char[] arr, String str) {
        // your code goes here
        int headIndex = 0, uniqueCounter = 0;
        String result = "";
        Map<Character,Integer> countMap = new HashMap<>();
        //Initialize Count Map
        for(int i = 0; i <= arr.length-1; i++){

            countMap.put(arr[i],0);
        }

        for(int j = 0; j <= str.length()-1;j++){
            char tailChar = str.charAt(j);
            //System.out.println(str.charAt(j));
            //Skip all characters not in arr

            if(!countMap.containsKey(tailChar))continue;
            int tailCount = countMap.get(tailChar);
            //System.out.println(tailChar+" "+tailCount);
            if(tailCount == 0)
                uniqueCounter +=1;

            countMap.put(tailChar,tailCount+1);

            //push head forward
            while(uniqueCounter == arr.length){
                int tempLength = j - headIndex + 1;
                if(tempLength == arr.length){
                    //Return a substring of str from headIndex to tailIndex (inclusive)
                    return str.substring(headIndex, j);
                }

                if(result == "" || tempLength < result.length()){
                    //Return a substring of str from headIndex to tailIndex (inclusive)
                    result = str.substring(headIndex,j);
                }
                char headChar = str.charAt(headIndex);

                if(countMap.containsKey(headChar)){
                    int headCount = countMap.get(headChar) - 1;
                    if(headCount == 0)
                        uniqueCounter -=1;

                    countMap.put(headChar,headCount);
                }
                headIndex +=1;
            }
        }

        return result;
    }
}
