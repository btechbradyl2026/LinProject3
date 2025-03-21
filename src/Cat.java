public class Cat extends Pet{

    public Cat (String n, int a, boolean v, String gender, int p, double w) {
        super(n, a, v, gender, p, w);
        wanted = w * 2;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Type: Cat");
    }
}
