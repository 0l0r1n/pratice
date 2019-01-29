class LCS {
    
    public static int solveRecursively(char[] p, char[] q, int n, int m) {
        if (n == 0 || m == 0) return 0;
        if (p[n - 1] == q[m - 1]) return 1 + solveRecursively(p, q, n - 1, m - 1);
        else return Math.max(solveRecursively(p, q, n - 1, m), solveRecursively(p, q, n, m -1));
    }

    public static int solveWithMatrix( char[] X, char[] Y, int m, int n ) { 
        int L[][] = new int[m+1][n+1]; 
        for (int i=0; i<=m; i++) { 
            for (int j=0; j<=n; j++) { 
                if (i == 0 || j == 0) L[i][j] = 0; 
                else if (X[i-1] == Y[j-1]) L[i][j] = L[i-1][j-1] + 1; 
                else L[i][j] = max(L[i-1][j], L[i][j-1]); 
        } 
    } 
        return L[m][n]; 
  } 
  
}