package garbage;

public interface A {
    void print();
}
class C implements A {
    int a;
    int b;
    public void print(){
        System.out.println("class c created");
    }
}

class B{
    public static void main(String[] args) {
        A var = new C();
        var.print();

    }
}