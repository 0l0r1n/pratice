class RepeatedNTimes {

    public static int solve(int[] A) {
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (s.contains(A[i])) return A[i];
            s.add(A[i]);
        }
        return -1;
    }
}