package ttd;

public class StringCalculator {

    public static int add(String numbers) {
        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            delimiter = String.valueOf(numbers.charAt(2));
            numbers = numbers.split("n")[1];
        }
        return addWithDelimiter(numbers, delimiter);
    }

    private static int addWithDelimiter(String numbers, String delimiter) {
        String[] numbersAr = numbers.split(delimiter + "|\n");
        int res = 0;
        for (String s : numbersAr) {
            if (!s.isEmpty()) {
                int nextInt = Integer.parseInt(s);
                if (nextInt < 0) {
                    throw new IllegalArgumentException();
                } else if (nextInt > 1000) {
                    continue;
                }
                res += nextInt;
            }
        }
        return res;
    }


}
