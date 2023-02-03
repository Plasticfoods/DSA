package Queue;

public class Q2 {
    public static void main(String[] args) throws QueueEmptyException {
        QueueLL<String> q = new QueueLL<>();
        q.push("abc");
        q.push("def");
        q.push("ghi");


        System.out.println(q.pop());
        System.out.println(q.peek());
    }
}
