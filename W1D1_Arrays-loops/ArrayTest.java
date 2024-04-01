import java.util.Arrays;
import java.util.ArrayList;

public class ArrayTest {

    public static void main(String[] args) {
        
        // ARRAYS
        // primitive arrays
        int[] numbers = {11,22,33};
        // numbers = new int[5]; // will always be length of 5 - limited memory
        System.out.println(Arrays.toString(numbers));

        // looping over primitive array
        for(int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        boolean[] votes = {true, false, true};
        char[] alphabet = {'a','b','c', 'c'};

        char letter = 'a';
        String something = " 'hello' ";
        // ------------ ARRAYLIST -------------------
        // 1. import ArrayList
        // 2. instantiate the ArrayList
        
        ArrayList<String> coolCars = new ArrayList<String>();
        coolCars.add("BWM");
        coolCars.add("Audi");
        coolCars.add("Mercedes");
        // System.out.println(coolCars);
    
        // instantiate the ArrayMethods File
        ArrayMethods x = new ArrayMethods();

        x.loopWithoutIndex(coolCars);



        

    }
}