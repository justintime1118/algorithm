package etc;

public class DecimalToBinary {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        int n = Integer.valueOf(args[0]);
        int divisor = 2;
        while (n > 0) {
            sb.append(n % divisor);
            n /= divisor;
        }
        String binary = sb.reverse().toString();
        System.out.println(binary);
    }
}
