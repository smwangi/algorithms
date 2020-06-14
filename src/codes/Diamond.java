package codes;

public class Diamond {

    public static void main(String[] args) {
      System.out.println(diamond(7));
    }
    static String diamond(int size){
        if(size % 2 == 0 || size <= 0)
            return null;

        StringBuilder diamond = new StringBuilder();
        for(int i = 1; i < size; i +=2){
            for (int j = 0; j < (size-i)/2;j++) diamond.append(" ");
            for( int k = 0; k < i;k++ )diamond.append("*");
            diamond.append("\n");
        }
        for(int i  = size; i > 0; i -=2){
            for (int j = 0;j <(size-i)/2;j++)diamond.append(" ");
            for (int k = 0;k < i;k++)diamond.append("*");
            diamond.append("\n");
        }
        return diamond.toString();
    }
}
