public class Dog extends Pet{

    public Dog (String n, int a, boolean v, String gender, int p, double w) {
        super(n, a, v, gender, p, w);
        price = p * 2;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Type: Dog");
    }
}
