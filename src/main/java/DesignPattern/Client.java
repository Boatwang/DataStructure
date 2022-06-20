package main.java.DesignPattern;

public class Client {
    public static void main(String[] args) {
        Drink order = new LongBlack();
        System.out.println("费用1=" + order.cost());
        System.out.println("描述" + order.getDes());

        order = new Milk(order);

        System.out.println("费用=" + order.cost());
        System.out.println("描述" + order.getDes());

        order = new Chocolate(order);

        System.out.println("费用=" + order.cost());
        System.out.println("描述" + order.getDes());

        order = new Soy(order);

        System.out.println("费用=" + order.cost());
        System.out.println("描述" + order.getDes());

    }
}
