/**
 * TowerOfHanoi
 */
public class TowerOfHanoi {

    public static void main(String[] args) {

        towerOfHanoi(3, 'A', 'C', 'B');
    }

    static void towerOfHanoi(int n, char from, char to, char aux){
        if(n == 1){
            System.out.println("Move disk 1 from "+from+" to "+to);
            return;
        }
        towerOfHanoi(n-1, from, aux, to);
        System.out.println("Move disk "+ n+" from "+from+" to "+to);
        towerOfHanoi(n-1, aux, to, from);
    }
}