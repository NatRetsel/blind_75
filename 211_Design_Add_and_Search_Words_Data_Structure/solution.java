class TrieNode {
    char val;
    boolean word;
    TrieNode[] children;

    TrieNode(char ch) {
        this.val = ch;
        this.word = false;
        this.children = new TrieNode[26];
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode('\0');
    }
    
    public void addWord(String word) {
        TrieNode curr = this.root;
        char[] charArray = word.toCharArray();
        for (char ch: charArray) {
            if (curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode(ch);
            }
            curr = curr.children[ch-'a'];
        }
        curr.word = true;
    }
    
    public boolean search(String word) {
        /*
                [b, d, m]
                [a] [a] [a]
                [d] [d] [d]
        */
        return searchHelper(word, this.root, 0);
    }

    private boolean searchHelper(String word, TrieNode curr, int currIdx) {
        for (int i= currIdx; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (TrieNode child: curr.children) {
                    if (child != null && searchHelper(word, child, i+1)) {
                        return true;
                    }
                }
                return false;
            }

            if (curr.children[ch-'a'] == null) return false;
            curr = curr.children[ch-'a'];
        }
        return curr.word;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */