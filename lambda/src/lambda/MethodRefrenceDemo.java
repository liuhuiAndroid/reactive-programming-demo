package lambda;

import java.util.function.*;

class Dog {
    private String name = "���";
    private int foodNum = 10;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public static void bark(Dog dog) {
        System.out.println(dog + "����");
    }

    // Ĭ�ϻ�ѵ�ǰʵ�����뵽�Ǿ�̬������������Ϊthis��λ���ǵ�һ��
    public int eat(int num) {
        System.out.println("����" + num + "�ﹷ��");
        this.foodNum -= num;
        return this.foodNum;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class MethodRefrenceDemo {

    public static void main(String[] args) {
        // ��������
        Consumer<String> consumer = System.out::println;
        consumer.accept("���ܵ�����");

        // ��̬�����ķ�������
        Consumer<Dog> consumer2 = Dog::bark;
        Dog dog = new Dog();
        consumer2.accept(dog);

        // �Ǿ�̬������ʹ�ö���ʵ���ķ�������
        // Function<Integer, Integer> function = dog::eat;
        // UnaryOperator<Integer> function = dog::eat;
        IntUnaryOperator function = dog::eat;
        System.out.println("��ʣ��" + function.applyAsInt(2) + "��");

        // ʹ����������������
        BiFunction<Dog, Integer, Integer> eatFunction = Dog::eat;
        System.out.println("��ʣ��" + eatFunction.apply(dog, 2) + "��");

        // ���캯���ķ�������
        Supplier<Dog> supplier = Dog::new;
        System.out.println("�������¶���" + supplier.get());

        // �������Ĺ��캯���ķ�������
        Function<String, Dog> function2 = Dog::new;
        System.out.println("�������¶���" + function2.apply("����"));
    }

}
