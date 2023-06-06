public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.make_sound();
        Cat c=new Cat();
        c.make_sound();
        System.out.println("Hello world!");

        int a=59;
        int b =64;
        System.out.println((double)a);

        FlyingBehaviour fl =new FastFlyingBehaviour();
        fl.fly();

    }
}