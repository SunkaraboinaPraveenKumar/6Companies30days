class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean eow=false;
        public TrieNode(){
            this.children=new TrieNode[46];
            this.eow=false;
        }
    }
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node=root;
        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if(node.children[idx]==null){
                node.children[idx]=new TrieNode();
            }
            node=node.children[idx];
        }
        node.eow=true;
    }
    
    public boolean search(String word) {
        return search(word,root);
    }
    public boolean search(String word, TrieNode root){
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            int idx=(ch=='.')?26:ch-'a';
            if(ch=='.'){
               for(TrieNode child:node.children) {
                    if(child!=null&&search(word.substring(i+1),child)){
                        return true;
                    }
               }
               return false;
            }
            if(node.children[idx]==null){
                return false;
            }
            node=node.children[idx];
        }
        return node.eow;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */