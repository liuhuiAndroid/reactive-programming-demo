package lambda;

import java.util.function.*;

class Dog {
    private String name = "大黄";
    private int foodNum = 10;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public static void bark(Dog dog) {
        System.out.println(dog + "叫了");
    }

    // 默认会把当前实例传入到非静态方法，参数名为this，位置是第一个
    public int eat(int num) {
        System.out.println("吃了" + num + "斤狗粮");
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
        // 方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("接受的数据");

        // 静态方法的方法引用
        Consumer<Dog> consumer2 = Dog::bark;
        Dog dog = new Dog();
        consumer2.accept(dog);

        // 非静态方法，使用对象实例的方法引用
        // Function<Integer, Integer> function = dog::eat;
        // UnaryOperator<Integer> function = dog::eat;
        IntUnaryOperator function = dog::eat;
        System.out.println("还剩下" + function.applyAsInt(2) + "斤");

        // 使用类名来方法引用
        BiFunction<Dog, Integer, Integer> eatFunction = Dog::eat;
        System.out.println("还剩下" + eatFunction.apply(dog, 2) + "斤");

        // 构造函数的方法引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println("创建了新对象：" + supplier.get());

        // 带参数的构造函数的方法引用
        Function<String, Dog> function2 = Dog::new;
        System.out.println("创建了新对象：" + function2.apply("旺财"));
    }

}
