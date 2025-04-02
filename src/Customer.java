public class Customer {
    private int age;
    private int bonus;
    private String type;
    private String gender;
    boolean vaccination;
    public Customer(int a, int b, String type, String g) {
        age = a;
        bonus = b;
        this.type = type;
        gender = g;
    }

    public void buy() {
        System.out.println("Hello, I would like a " + type + ", who's " + age + " years old, who's also " + gender + " and I'm willing to pay an additional " + bonus);
    }

    public void decline() {
        System.out.println("I don't want that pet!");
    }

    public int getBonus() {
        return bonus;
    }

    public boolean requires(Pet pet) {
            if (pet instanceof Dog) {
                if (type.equals("dog")) {
                    if (pet.getAge() == age) {
                        if (pet.getGender().equals(gender)) {
                            return true;
                        }
                    }
                }
            } else if (pet instanceof Cat) {
                if (type.equals("cat")) {
                    if (pet.getAge() == age) {
                        if (pet.getGender().equals(gender)) {
                            return true;
                        }
                    }
                }
            }
        return false;
    }

}
