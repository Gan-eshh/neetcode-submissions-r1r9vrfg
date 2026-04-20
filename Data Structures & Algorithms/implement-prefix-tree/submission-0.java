class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();     
    }

    public void insert(String word) {
        TrieNode cur = root;

        for(char ch : word.toCharArray()){
            int i=ch-'a';
            if(cur.children[i] == null)
                cur.children[i] = new TrieNode();
            cur = cur.children[i];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            int i=ch -'a';
            if(cur.children[i] == null)
                return false;
            cur = cur.children[i];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char ch : prefix.toCharArray()){
            int i=ch-'a';
            if(cur.children[i] == null)
                return false;
            cur = cur.children[i];
        }
        return true;
    }
}
