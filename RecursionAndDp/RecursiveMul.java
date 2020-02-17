package RecursionAndDp;

public class RecursiveMul {
    /* My solution not using * operator. */
    public int mul(int m, int n) {
        if (m == 2) return n << 1;
        else if (n == 2) return m << 1;
        
        if (m % 2 == 0 && n % 2 == 0) {
            return mul(2, mul(m >> 1, n));
        } else if (m % 2 == 0 && n % 2 != 0) {
            return mul(m, n - 1) + m;
        } else if (m % 2 != 0 && n % 2 == 0) {
            return mul(m - 1, n) + n;
        } else {
            return mul(m - 1, n - 1) + m + n;
        }
    }

    /* Elegant and concise solution. */
    public int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProductHelper(smaller, bigger);
    }

    /* Helper method. */
    public int minProductHelper(int smaller, int bigger) {
        if (smaller == 0) return 0;
        else if (smaller == 1) return bigger;

        int s = smaller >> 1;
        int halfProd = minProductHelper(s, bigger);

        if (smaller % 2 == 0) {
            return halfProd + halfProd;
        } else {
            return halfProd + halfProd + bigger;
        }
    }

    public static void main(String[] args) {
        RecursiveMul test = new RecursiveMul();
        System.out.println(test.mul(2, 3));
        System.out.println(test.mul(3, 2));
        System.out.println(test.mul(8, 9));
        System.out.println(test.mul(9, 8));
        System.out.println(test.mul(4, 4));
        System.out.println(test.mul(3, 3));
    }
}   