package common;

public final class Utils {
    /**
     * Hidden constructor.
     */
    private Utils() { }

    /**
     * Calculates the sum of the first n integers, from 1 to n, using the formula.
     * @param n the biggest integer
     * @return the sum of the first n integers from 1 to n
     */
    public static int getSumOfFirstNIntegers(final int n) {
        return n * (n + 1) / 2;
    }
}
