package TrieWordBreakBoggleBoard;

public class PrefixTrie {
   /* private TrieNode root;
    public PrefixTrie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for(int i = 0; i<word.length() ; i++){
            char c = word.charAt(i);
            int index = c -'a';
            if(temp.children[index] == null){
                TrieNode tmpNode = new TrieNode();
                temp.children[index] = tmpNode;
                temp = tmpNode;
            } else{
                temp = temp.children[index];
            }
        }
        temp.isLeaf = true;

    }

    public boolean search(String word) {
        TrieNode res = searchTrieNode(word);
        if(res != null){
            if(res.isLeaf)
                return true;
        }
        return false;
    }

    public TrieNode searchTrieNode(String word) {
        TrieNode retNode = root;
        for(int i = 0; i<word.length() ; i++){
            char c = word.charAt(i);
            int index = c -'a';
            if(root.children[index]!=null){
                retNode = root.children[index];
            } else{
                return null;
            }
            if(retNode == root) return null;
            return retNode;
        }

        return retNode;
    }

    public boolean startsWith(String prefix) {
        TrieNode res = searchTrieNode(prefix);
        if(res == null) return false;
        return true;
    }

  /*  private class TrieNode{
        TrieNode[] children;
        boolean isLeaf;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }*/
}


