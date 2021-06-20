/**
 * The number which is only divisible by itself and 1 is known as prime number. For example 2, 3, 5, 7…are prime numbers.
 * Here we will see two programs: 1) First program will print the prime numbers between 1 and 100 2)
 * Second program takes the value of n (entered by user) and prints the prime numbers between 1 and n.
 */
public class PrimeNumber {
    public static void main(String[] args) {
        printPrime(100);
        findPrime(97);
        printPrime2(100);
    }
    
    /**
     * 1) We are finding the prime numbers within the limit.
     *
     * 2) Read the “n” value using scanner object  sc.nextInt()and store it in the variable n.
     *
     * 3) The for loop iterates from j=2 to j=given number. then count assigned to 0, the inner loop finds the divisors of each j value, count value represents no.of divisors. If count=2, then that number is a prime number.
     * @param N
     */
    static void printPrime(int N) {
        int i, count;
        for (int j = 2; j <= N; j++) {
            count = 0;
            for (i = 1; i <= j; i++) {
                if (j % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.print(j+" ");
            }
        }
        System.out.println();
    }
    
    static void printPrime2(int n) {
        int i =0;
        int num =0;
        //Empty String
        String  primeNumbers = "";
        System.out.println("Enter the value of n:");
        
        for (i = 1; i <= n; i++)
        {
            int counter=0;
            for(num =i; num>=1; num--)
            {
                if(i%num==0)
                {
                    counter = counter + 1;
                }
            }
            if (counter ==2)
            {
                //Appended the Prime number to the String
                primeNumbers = primeNumbers + i + " ";
            }
        }
        System.out.println("Prime numbers from 1 to n are :");
        System.out.println(primeNumbers);
    }
    
    /**
     * 1) In this program, the while loop is present in the constructor. If we instantiate the class then automatically constructor will be executed.
     *
     * 2) Read the “n” value using scanner class object sc.nextInt(). FindPrime class is initiated in the class Prime as new FindPrime(n); then the constructor of FindPrime will be executed.
     *
     * The while loop iterates until i<=num is false. The remainder of number/i=0 then count will be increased by 1, “i” value increased by 1. If count=2, then print “number is a prime number”.
     * @param num
     */
    static void findPrime(int num) {
        int count = 0, i = 1;
        while (i <= num) {
            if (num % i == 0) {
                count++;
            }
            i++;
        }
        if (count == 2)
            System.out.println(num+" is a prime number. ");
        else
            System.out.println(num + " is Not a prime number. ");
    }
    
    /**
     * 1) A prime number is a number which has no positive divisors other than 1 and itself.
     *
     * 2) We are finding the given number is prime or not using the static method primeCal(int num).
     * For loop iterates from i=0 to i=given number, if the remainder of number/i =0 then increases the count by 1.
     * After all the iterations, if count=2, then that number is a prime number.
     * @param num
     */
    static void primeCal(int num)
    {
        int count=0;
        for(int i=1;i<=num;i++)
        {
            if(num%i==0)
            {
                count++;
            }
        }
        if(count==2)
            System.out.println("prime number ");
        else
            System.out.println("Not a prime number ");
    }
}
