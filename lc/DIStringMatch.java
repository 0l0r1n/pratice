/*
  942. DI String Match
Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

If S[i] == "I", then A[i] < A[i+1]
If S[i] == "D", then A[i] > A[i+1]
 

*/
class DIStringMatch {
  public static int[] solve(String S) {
      int lo = S.length() + 1;
      int hi = -1;
      int[] result = new int[S.length() + 1];
      for (int i = 0; i < S.length(); i++ ) {
          if (S.charAt(i) == 'I') result[i] =++hi;
          else result[i] = --lo;
      }
      result[S.length()] = --lo;
      return result;
  }
}