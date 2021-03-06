class Knapsack {

    private Item[] items;
    private int capacity;

    public Knapsack(Item[] items, int capacity) {
        this.items = items;
        this.capacity = capacity;
    }

    public Solution solve() {
        int NB_ITEMS = items.length;
        int[][] matrix = new int[NB_ITEMS + 1][capacity + 1];

        for (int i = 0; i <= capacity; i++)
            matrix[0][i] = 0;
        
        for (int i = 1; i <= NB_ITEMS; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (items[i - 1].weight > j) matrix[i][j] = matrix[i-1][j];
                else matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j - items[i-1].weight] + items[i-1].value);
            }
        }
        
        int res = matrix[NB_ITEMS][capacity];
        int w = capacity;
        List<Item> itemsSolution = new ArrayList<>();

        for (int i = NB_ITEMS; i > 0  &&  res > 0; i--) {
            if (res != matrix[i-1][w]) {
                itemsSolution.add(items[i-1]);
              
                res -= items[i-1].value;
                w -= items[i-1].weight;
            }
        }

        return new Solution(itemsSolution, matrix[NB_ITEMS][capacity]);
    }

    public class Solution {
	
        public List<Item> items;
        public int value;
        
        public Solution(List<Item> items, int value) {
            this.items = items;
            this.value = value;
        }
 
    }

    public class Item {
        public int value;
        public int weight;
    }

}