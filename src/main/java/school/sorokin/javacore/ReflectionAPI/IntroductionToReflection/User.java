package school.sorokin.javacore.ReflectionAPI.IntroductionToReflection;

public class User {

    private String name;
    private int age;
    private long id;

    public User(String name, int age, long id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
