import java.util.HashMap;

class Trie {
    
    TrieNode root;


    void insert(String word) {
        TrieNode current = root;
     
        for (int i = 0; i < word.length(); i++) 
            current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        
        current.setEndOfWord(true);
    }

    boolean find(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) return false;
        }
        return current.isEndOfWord();
    }

    void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.endOfWord) return false;
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();
    
        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    class TrieNode {
        private HashMap<Character, TrieNode> children;        
        private boolean endOfWord;

        TrieNode() {
            children = new HashMap<>();
        }

        boolean isEndOfWord() {
            return endOfWord;
        }

        void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }

        HashMap<Character, TrieNode> getChildren() {
            return children;
        }
    }
}