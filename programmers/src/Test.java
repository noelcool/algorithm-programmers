import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<Integer> list = new ArrayList<>();

//        for (int i = 0; i < Integer.parseInt(input); i++) {
//            String[] inputList = br.readLine().split(" ");
//            list.add(inputList);
//        }

        for (int i = 0; i < Integer.parseInt(input); i++) {
            String in = br.readLine();
            list.add(Integer.parseInt(in));
        }
        boolean grow = false;
        for (int i=1; i < list.size(); i++) {
            if(list.get(i) > list.get(i-1)) {

            }
        }

    }
}
