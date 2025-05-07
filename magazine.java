import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result3 {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        int n1 = magazine.size();
        int n2 = note.size();

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<n1;i++) {
            if(map.containsKey(magazine.get(i))) map.put(magazine.get(i), map.get(magazine.get(i))+1);
            else map.put(magazine.get(i),1);
        }

        for(int i=0;i<n2;i++) {
            if(map.containsKey(note.get(i))) {
                int temp = map.get(note.get(i));
                map.remove(note.get(i));
                if(temp > 1) map.put(note.get(i), temp-1);
            }
            else {
                System.out.println("No");
                return;
            }
        }

        System.out.print("Yes");
    }

}

public class magazine {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
