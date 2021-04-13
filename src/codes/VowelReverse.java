import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class VowelReverse {

    public static void main(String[] args) throws JsonProcessingException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        
        Map<String,String> map = new HashMap<>();
     
        map.put("Command","LoadForIntegration");
        map.put("IsIntregated","true");
        map.put("AccType","Account 01020007428000");
        map.put("Amount","100");
        map.put("TransId","11");
        /*map.put("Username","fbesigcap");
        map.put("Password","P@ssw0rd");*/
        map.put("Username","gochieng");
        map.put("Password","pass123*");
        map.put("ORGURL","http://server/bank/return.html");
        
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(map);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://nbksigcap/webret/webretrieve.dll"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
    
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        
        VowelReverse reverse = new VowelReverse();
        String s = "leetcode";
        System.out.println(reverse.reverseVowels(s));
        rev("Samuel is Cooking");
    }

    public String reverseVowels(String s) {
        Set<Character> characterSet = new HashSet<>(Arrays.asList('a', 'e','i','o','u'));
        int l = 0,r = s.length()-1;
        char[] chars = s.toCharArray();
        while (l < r){
            System.out.println(l+" "+r);
            if(!characterSet.contains(s.charAt(l)))
                l++;
            else if(!characterSet.contains(s.charAt(r)))
                r--;
            else{
                swap(chars,l,r);
                System.out.println(s);
                l++;
                r--;
            }

        }
        return new String(chars);
    }

    static void rev(String s){
        char[] chars = s.toCharArray();
        int l = 0,r = s.length()-1;
        while (l < r){
            swap(chars,l,r);
            l++;
            r--;
        }
        System.out.println(Arrays.toString(chars));
    }

    private static void swap(char[] c,int l, int r){
        char temp = c[l];
        c[l] = c[r];
        c[r] = temp;
    }
}
