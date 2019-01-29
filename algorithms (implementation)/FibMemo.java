public class FibMemo {

    int fib(int n, int[] memo) {
        if (n < 0) return 0;
        if (n == 1) return 1;
        if (memo[n]) memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    }

}