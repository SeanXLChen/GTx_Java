import java.util.ArrayList;

public class test {
    public static void letsGetEven( ArrayList<Integer> nums ) {
        for (int i = nums.size()-1; i >= 0; i--) {
            if (nums.get(i) / 2 == 0) {
                nums.delete(i);
            }
        }
     }

    public static void main(String[] args) {
        
    }
}
