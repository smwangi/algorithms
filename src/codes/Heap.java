import java.util.ArrayList;

public class Heap {
    public static void main(String[] args) {
    
        Heap heap = new Heap();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int size = arrayList.size();
        heap.insert(arrayList, 3);
        heap.insert(arrayList, 4);
        heap.insert(arrayList, 9);
        heap.insert(arrayList, 5);
        heap.insert(arrayList, 2);
        
        System.out.println("Max Heap Array: ");
        heap.printArray(arrayList, size);
        
        heap.deleteNode(arrayList, 4);
        System.out.println("After deleting an element: ");
        heap.printArray(arrayList, size);
    }
    void heapify(ArrayList<Integer> hT, int i) {
        int size = hT.size();
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        
        if (l < size && hT.get(l) > hT.get(largest))
            largest = l;
        
        if(r < size && hT.get(l) > hT.get(largest))
            largest = r;
        
        if (largest != i) {
            int temp = hT.get(largest);
            hT.set(largest, hT.get(i));
            
            heapify(hT, largest);
        }
    }
    
    void insert(ArrayList<Integer> hT, int newNum) {
        int size = hT.size();
        if (size == 0) {
            hT.add(newNum);
        } else {
            hT.add(newNum);
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(hT, i);
            }
        }
    }
    
    void deleteNode(ArrayList<Integer> hT, int num) {
        int size = hT.size();
        int i;
        for (i = 0; i < size; i++) {
            if (num == hT.get(i))
                break;
        }
        int temp = hT.get(i);
        hT.set(i, hT.get(size - 1));
        hT.set(size - 1, temp);
        
        hT.remove(size - 1);
        for (int j = size / 2 - 1; j >= 0; j--) {
            heapify(hT, j);
        }
    }
    
    void printArray(ArrayList<Integer> arrayList, int size) {
        for (Integer i : arrayList) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
