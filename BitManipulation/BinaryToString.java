package BitManipulation;

public class BinaryToString {
    /* Print out the binary representation of the real number between 0 and 1. 
     * For this method we compare to 1.
     * We can also compare to 0.5/ 0.25/ 0.125 and so on.
     */
    public String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "Error";
        }

        StringBuilder binary = new StringBuilder();

        binary.append(".");
        while (num > 0) {
            if (binary.length() >= 32) {
                return "Error";
            }

            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }

        return binary.toString();
    }

    public static void main(String[] args) {
        BinaryToString test = new BinaryToString();
        System.out.println(test.printBinary(0.625));
        System.out.println(test.printBinary(0.4));
    }
}
