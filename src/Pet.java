public class Pet {
    String name;
    int age;
    boolean vaccinated;
    String gender;
    int price;
    double wanted;

    public Pet (String n, int a, boolean v, String gender, int p, double w) {
        name = n;
        age = a;
        vaccinated = v;
        this.gender = gender;
        price = p;
        wanted = w;
    }

    public void printInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Vaccination Status: " + isVaccinated());
        System.out.println("Gender: " + getGender());
        System.out.println("Price Bonus: " + getPrice());
        System.out.println("Wantedness: " + getWanted());
    }

    public double getWanted() {
        return wanted;
    }

    public int getPrice() {
        return price;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void vaccinate() {
        vaccinated = true;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setWanted(double wanted) {
        this.wanted = wanted;
    }
}
