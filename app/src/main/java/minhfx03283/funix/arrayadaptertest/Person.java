package minhfx03283.funix.arrayadaptertest;

public class Person {
    private String name;
    private int age;
    private String[] foo;

    public String[] getFoo() {
        return foo;
    }

    public void setFoo(String[] foo) {
        this.foo = foo;
    }

    public Person(String name, int age, String[] foo) {
        this.name = name;
        this.age = age;
        this.foo = foo;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
