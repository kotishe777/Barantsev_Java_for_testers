package learn_java.sandbox;

public class MyFirstProgram{

  public static void main(String[] args){
    hello("world");
    hello("user");
    hello("Alexei");

    Square q = new Square(5);
    System.out.println("Площадь квадрата со стороной " + q.l + " = " + q.area());

    Rectangle r = new Rectangle(4,6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
}
  public static void hello(String somebody){
    System.out.println("Hello, " + somebody + "!");
  }
}