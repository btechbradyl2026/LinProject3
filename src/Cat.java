public class Cat extends Pet{

    public Cat (String n, int a, boolean v, String gender, int p) {
        super(n, a, v, gender, p);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Type: Cat");
    }

    @Override
    public String printNeeded() {
        return super.printNeeded() + "cat|";
    }
}
