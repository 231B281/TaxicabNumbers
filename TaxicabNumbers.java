import java.util.*;

public class TaxicabNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int N = scanner.nextInt();

        // Map to store sum -> list of (a, b) pairs
        Map<Integer, List<String>> cubeSums = new HashMap<>();

        for (int a = 1; a * a * a <= N; a++) {
            for (int b = a; b * b * b <= N; b++) {  // b starts at a to avoid duplicate (b,a)
                int sum = a * a * a + b * b * b;
                if (sum > N) break;

                String pair = a + "^3 + " + b + "^3";
                cubeSums.computeIfAbsent(sum, k -> new ArrayList<>()).add(pair);
            }
        }

        System.out.println("\nTaxicab numbers up to " + N + ":");

        for (Map.Entry<Integer, List<String>> entry : cubeSums.entrySet()) {
            List<String> pairs = entry.getValue();
            if (pairs.size() >= 2) {
                System.out.println(entry.getKey() + " can be expressed as:");
                for (String pair : pairs) {
                    System.out.println("  " + pair);
                }
                System.out.println();
            }
        }
    }
}
