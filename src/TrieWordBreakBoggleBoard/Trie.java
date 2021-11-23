package TrieWordBreakBoggleBoard;

class Trie {

    public Trie[] children;
    public boolean isLeaf;

    public Trie(){
        isLeaf = false;
        children = new Trie[26];
    }

    public void insert(String word){
        int i = 0;
        char[] ch = word.toCharArray();
        Trie curr = this;
        while(curr !=null && i<ch.length && curr.children[ch[i] -'a']!=null){
            curr = curr.children[ch[i] -'a'];
            i++;
        }

        if(i == ch.length){
            curr.isLeaf = true;
            return;
        }

        for(;i<ch.length;i++){
            Trie temp = new Trie();
            curr.children[ch[i] - 'a'] = temp;
            curr = temp;
        }

        curr.isLeaf = true;
    }

    public boolean search(String word){
        int i = 0;
        char[] ch = word.toCharArray();
        Trie curr = this;
        while(curr !=null && i<ch.length && curr.children[ch[i] -'a']!=null){
            curr = curr.children[ch[i] -'a'];
            i++;
        }
        if(i == ch.length && curr.isLeaf){
            return true;
        }
        return false;
    }

    public boolean startsWith(String word){
        int i = 0;
        char[] ch = word.toCharArray();
        Trie curr = this;
        while(curr !=null && i<ch.length && curr.children[ch[i] -'a']!=null){
            curr = curr.children[ch[i] -'a'];
            i++;
        }
        if(i == ch.length){
            return true;
        }
        return false;
    }
    /*
    Input
    ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
    [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
    Output
    [null, null, true, false, true, null, true]


     */
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // return True
        trie.search("app");     // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
        trie.search("app");     // return True

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */