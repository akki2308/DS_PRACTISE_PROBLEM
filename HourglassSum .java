import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static int hourglassSum(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i <= arr.size() - 3; i++) {
            for(int j = 0; j <= arr.get(0).size() - 3; j++) {
                int sum = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2)
                        + arr.get(i+1).get(j+1)
                        + arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);

                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}

class HourglassSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Integer>> arr = new ArrayList<>();

        System.out.println("Enter 6 rows of 6 integers each:");

        for (int i = 0; i < 6; i++) {
            String[] line = bufferedReader.readLine().trim().split(" ");
            List<Integer> row = Arrays.stream(line)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            arr.add(row);
        }

        int result = Result.hourglassSum(arr);

        bufferedWriter.write("Maximum Hourglass Sum: " + result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
