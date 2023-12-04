class TrieNode {
    public char value;
    public boolean word;
    public TrieNode[] children;
    
    public TrieNode(char ch) {
        this.value = ch;
        this.word = false;
        this.children = new TrieNode[26];
    }
}
class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode('\0');
    }
    
    public void insert(String word) {
        TrieNode curr = this.root;
        char[] charArray = word.toCharArray();
        for (char ch: charArray) {
            if (curr.children[ch - 'a'] == null) { // if at the character's position is doesn't exist a node, create it
                curr.children[ch-'a'] = new TrieNode(ch);
            }
            curr = curr.children[ch-'a'];

        }
        curr.word = true; //mark the end of a word
    }
    
    public boolean search(String word) {
        TrieNode curr = this.root;
        char[] charArray = word.toCharArray();
        for (char ch: charArray) {
            if (curr.children[ch-'a'] == null) {
                return false;
            }
            curr = curr.children[ch-'a'];
        }
        return curr.word;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        char[] charArray = prefix.toCharArray();
        for (char ch: charArray) {
            if (curr.children[ch-'a'] == null) {
                return false;
            }
            curr = curr.children[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */