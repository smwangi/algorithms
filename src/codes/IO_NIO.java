import java.io.BufferedReader;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.IIOException;
/**
 * IO_NIO
 */
public class IO_NIO {

    public static void main(String[] args) throws IOException {
        
        scan();
        console();
    }

    static void ByteStream() throws IOException{
        FileInputStream in = null;
        FileOutputStream out = null;

        try{

            in  =   new FileInputStream("xanadu.txt");
            out =   new FileOutputStream("outagain.txt");
            int c;
            while((c = in.read()) != -1){
                out.write(c);
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            if(in!= null){
                in.close();
            }
            if(out != null){
                 out.close();
            }
           
        }
    }

    static void CharacterStream() throws IOException{
    
        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader("xanadu.txt");
            out = new FileWriter("outagain.txt");
            int c;
            while((c = in.read()) != -1){
                out.write(c);
            }    
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }finally{
            if(in != null){
                in.close();
            }
            if(out != null){
                out.close();
            }
        }
    }

    static void scan() throws IIOException{
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));
            s.useDelimiter(",\\s*");
            while(s.hasNext()){
                System.out.println(s.next());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally{
            if(s != null){
                s.close();
            }
        }
    }

    static void console(){
        Console c  = System.console();
        if(c == null){
            System.err.println("No Console");
            System.exit(1);
        }

        String login = c.readLine("Enter password");
        //char[] password = c.readPassword("enter password");

        c.format("Passwords do not match Try again.%n", login);
    }
}