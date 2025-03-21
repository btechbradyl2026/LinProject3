public class Customer {
    private int age;
    private int bonus;
    private String type;
    private String gender;
    boolean vaccination;
    public Customer(int a, int b, String type, String g, boolean v) {
        age = a;
        bonus = b;
        this.type = type;
        gender = g;
        vaccination = v;
    }

    public void buy() {
        System.out.println("Hello, I would like " + type + " who's vaccination status is " + vaccination + ", who's " + age + " years old, and I'm willing to pay an additional " + bonus);
    }


}
