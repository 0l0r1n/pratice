public interface IUF {
    UF(int N); // initiates the data structure
    void union(int p, int q); // adds connection between p and q
    boolean connected(int p, int q); // are p and q in the same component?
    int find(int p); // component identifier for p
    int count(); // number of components
}