package Tries;

class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}



public class Trie {
    private TrieNode root;
    public int count;
    public Trie() {
        root = new TrieNode('\0');
    }

    public boolean search(String word){
        // Write your code herr
        return search(root,word);
    }

    private boolean search(TrieNode root, String word){
        if(word.length()==0){
            return root.isTerminating;
        }

        int index = word.charAt(0)-'a';
        TrieNode child = root.children[index];
        if(child==null)
            return false;

        return search(child,word.substring(1));
    }


    private void add(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        add(root.children[childIndex], word.substring(1));

    }

    public void add(String word){
        add(root, word);
    }

    public void delete(String word){
        delete(root,word);
    }

    private void delete(TrieNode root, String word){
        if(word.length()==0){
            root.isTerminating = false;
            return;
        }

        int index = word.charAt(0)-'a';
        TrieNode child = root.children[index];
        if(child==null)
            return;
        delete(child,word.substring(1));
        if(!child.isTerminating && child.childCount==0){
            root.children[index] = null;
            child = null;
            root.childCount--;
        }
    }

}
