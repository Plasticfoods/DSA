package Tries;

public class Main {
    public static void main(String[] args) {
        Trie tr = new Trie();
        tr.add("two");
        tr.add("news");
        tr.add("new");
        tr.delete("new");
        System.out.println(tr.search("news"));
    }
}
