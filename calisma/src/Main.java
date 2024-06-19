import java.util.ArrayList;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static boolean unique1(int[] data) {
        int n = data.length;
        for (int j = 0; j < n-1; j++) {
            for (int k = j + 1; k < n; k++) {
                if (data[j] == data[k])
                    return false;
            }
        }
        return true;
    }
    public static boolean unique2(int [] data) {
        int n = data.length;
        int [] temp = Arrays.copyOf(data,n);
        Arrays.sort(temp);
        for(int j=0;j<n-1;j++){
            if(temp[j]==temp[j+1])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 6, 9};
        System.out.println(unique1(arr));
    }
   
}