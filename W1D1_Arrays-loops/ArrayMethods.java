import java.util.ArrayList;

public class ArrayMethods{

    public void loopOverStuff(ArrayList<String> someArray) {
        // System.out.println(someArray);
        for(int i = 0;  i < someArray.size(); i++) {
            if (someArray.get(i).length() >= 4) {

                System.out.println(someArray.get(i));
            }
        }
    }

    public void loopWithoutIndex(ArrayList<String> anArrayOfStrings) {
        for(String eachCar : anArrayOfStrings) {
            System.out.println(eachCar);
        }
    }
}