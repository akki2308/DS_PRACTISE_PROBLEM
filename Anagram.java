import java.io.*;

class Result {

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */
    public static int makingAnagrams(String s1, String s2) {
        int[] count = new int[26]; // to store frequency of each character

        // Count characters in s1
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            count[ch - 'a']++;
        }

        // Subtract characters in s2
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            count[ch - 'a']--;
        }

        // Sum absolute values to get total deletions
        int deletions = 0;
        for (int i = 0; i < 26; i++) {
            deletions += Math.abs(count[i]);
        }

        return deletions;
    }
}

public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();

        int result = Result.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

