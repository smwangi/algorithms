

public class MinNumberofCoins {

    public static void main(String[] args) {

        int[] arr = {1};
        System.out.println( minNumOfCoins(arr,2));
    }

    static int minNumOfCoins(int[] coinList, int v){

        //if(coinList.length == 1 && coinList[0] < v)
          //  return -1;
        //num coins will be storing the min number of coins required for i value
        //numCoins[v] will have result

        int[] coins = new int[v+1];

        int tempCoins = 0;
        //base case if give value v is 0;
        coins[0] = 0;

        //initialize all table values as infinite
        for (int k=1;k <= v;k++)
            coins[k] = Integer.MAX_VALUE;

        //Compute minimum coins required for all values 1 to v
        for(int i = 1; i <= v; i++){

            //Go through all coins smaller or equal to i
            for (int j = 0; j < coinList.length; j++){
                System.out.print(" "+coinList[j]);
                if(coinList[j] <= i){
                    //System.out.print(" "+coinList[j]);
                    //System.out.println();
                    tempCoins = coins[i - coinList[j]];
                    //System.out.print(" "+tempCoins);
                    if(tempCoins != Integer.MAX_VALUE && tempCoins + 1 < coins[i])
                        coins[i] = tempCoins + 1;

                }

            }
        }
        return coins[v] == Integer.MAX_VALUE ? -1 : coins[v];
       // Arrays.stream(table).forEachOrdered(System.out::println);
    }
}
