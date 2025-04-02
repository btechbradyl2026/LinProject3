public class Pet {
    String name;
    int age;
    boolean vaccinated;
    String gender;
    int price;

    public Pet (String n, int a, boolean v, String gender, int p) {
        name = n;
        age = a;
        vaccinated = v;
        this.gender = gender;
        price = p;
    }

    public String toString() {
        return getName();
    }

    public String printNeeded() {
        return ("|A: " + getAge() + ", G: " + getGender() + ", T: ");
    }

    public void printInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Vaccination Status: " + isVaccinated());
        System.out.println("Gender: " + getGender());
        System.out.println("Price Bonus: " + getPrice());

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

    public void setName(String name) {
        this.name = name;
    }
}
