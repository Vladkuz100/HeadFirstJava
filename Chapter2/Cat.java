package Chapter2;

import java.sql.SQLOutput;

public class Cat {
    private int age;
    private double weight;
    private static int number =0;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public void getInfo(){
        System.out.printf("Cat -   age = %d  weight = %.4f \n" , age, weight );
    }

    public Cat(){
        this.age=10;
        this.weight = 20.3;
    }

    public Cat ( int age, double weight ){
        this.age=age;
        this.weight = weight;
    }
}
