//Check if two strings are a rotation of one another
public class StringRotation {

    public static void main(String[] args) {
        String s1= "ABACD";
        String s2 = "CDABA";
        //s1+s1 = ABA'CDABA'CD
        System.out.println(isStrRotated(s1,s2));
    }

    static boolean isStrRotated(String s1, String s2){
        //The lengths must be the same and s2 must be a substring of s1 concatenated with s1
        System.out.println((s1+s1).indexOf(s2));
        int N = 5,k=2;
        for(int i = 0; i< N;i++){
            System.out.println((i+k)%N);
        }
       return (s1.length() == s2.length() && (s1+s1).indexOf(s2) != -1 );

    }
}
