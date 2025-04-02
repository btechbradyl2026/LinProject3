public class Dog extends Pet{

    public Dog (String n, int a, boolean v, String gender, int p) {
        super(n, a, v, gender, p);
        price = p * 2;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Type: Dog");
    }
    @Override
    public String printNeeded() {
        return super.printNeeded() + "dog|";
    }
}
