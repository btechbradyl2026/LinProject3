import java.io.File;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PetStore {
    int money;
    ArrayList<String> names = new ArrayList<String>();
    Pet[][] pets = new Pet[0][5];
    int turns;
    Scanner scan = new Scanner(System.in);

    public PetStore (int money) {
        this.money = money;
        turns = 0;
    }

    public void loop () {
        while (money < 1000) {
            String user = "";
            System.out.println("Menu: ");
            System.out.println("(P)rint pets");
            System.out.println("(G)enerate 5 new pets (Costs 50 dollars)");
            System.out.println("(V)accinate a row of pets (Costs 25 dollars)");
            System.out.println("(N)ext turn");
            System.out.println("(C)heck pet");
            System.out.println("Your current balance is " + money);
            user = scan.nextLine();
            if (user.equals("P")) {
                printPets();
            } else if (user.equals("G")) {
                System.out.println("cat or dog?");
                String cd = scan.nextLine();
                generatePet(cd);
            } else if (user.equals("V")) {
                System.out.println("Which row would you like to vaccinate?");
                printPets();
                int r = scan.nextInt();
                scan.nextLine();
                for (int i = 0; i < pets[0].length; i ++) {
                    pets[r - 1][i].vaccinate();
                }
                setMoney(money - 25);
                System.out.println("Pets in row " + r + " have been vaccinated");
            } else if (user.equals("N")) {
                Customer temp = generateCustomer();
                temp.buy();
                System.out.println("Sell a pet to the customer? (Y/N) (C to check pet inventory)");
                printPets();
                String option = scan.nextLine();
                int guh = 0;
                while (guh == 0) {
                    option = scan.nextLine();
                    if (option.equals("Y")) {
                        System.out.println("Which pet would you like to sell? (ROW)");
                        printPets();
                        int row = scan.nextInt();
                        System.out.println("Which pet would you like to sell? (COL)");
                        int col = scan.nextInt();
                        if (temp.requires(selectPet(row, col))) {
                            System.out.println(pets[row][col].getName() + " was sold for " + (temp.getBonus() + pets[row][col].getPrice()) + " dollars");
                            pets[row][col].setName("gone");
                            setMoney(money + temp.getBonus() + pets[row][col].getPrice());
                            guh = 1;
                            pets[row][col] = new Pet("gone", 0, false, "N/A", 0, 0);
                        } else {
                            temp.decline();
                            guh = 1;
                        }
                    } else if (option.equals("N")) {
                        System.out.println("You declined the customer's request for a pet");
                        guh = 1;
                    } else if (option.equals("C")) {
                        System.out.println("Which row of pet info would you like to check?");
                        int r = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Which col of pet info would you like to check?");
                        int c = scan.nextInt();
                        scan.nextLine();
                        selectPet(r, c).printInfo();
                        System.out.println("The pet in row " + " and column " + c + "'s info is being shown");
                    }
                }
                turns++;
                infections();
            } else if (user.equals("C")) {
                System.out.println("Which row of pet info would you like to check?");
                int r = scan.nextInt();
                scan.nextLine();
                System.out.println("Which col of pet info would you like to check?");
                int c = scan.nextInt();
                scan.nextLine();
                selectPet(r, c).printInfo();
                System.out.println("The pet in row " + r + " and column " + c + "'s info is being shown");
            }
        }
        System.out.println("You won!");
        System.exit(1);
    }

    public Customer generateCustomer () {
        String type;
        if (genderGen().equals("male")) {
            type = "cat";
        } else {
            type = "dog";
        }
        return new Customer(ageGen(), priceGen(), type, genderGen());
    }

    public void welcome() {
        System.out.println("Hello and welcome to PetManagerCo!");
        System.out.println("Your goal is to make a thousand dollars of profit in the fewest turns possible!");
        getNames();
        loop();
    }

    public void generatePet(String cd) {
        Pet currentPet;
        Pet[] newRow = new Pet[5];
        for (int i = 0; i < 5; i ++) {
            if (cd.equals("cat")) {
                int price = priceGen();
                double want = ((double) price/100 - 95) * -1;
                currentPet = new Cat(nameGen(), ageGen(), false ,genderGen(), price, want);
            } else if (cd.equals("dog")) {
                int price = priceGen();
                double want = ((double) price/100 - 95) * -1;
                currentPet = new Dog(nameGen(), ageGen(), false ,genderGen(), price, want);
            } else {
                System.out.println("Please enter \"cat\" or \"dog\" in the second slot");
                break;
            }
            newRow[i] = currentPet;
        }
        Pet[][] temp = new Pet[pets.length + 1][5];
        setMoney(getMoney() - 50);
        for (int i = 0; i < pets.length; i ++) {
            for (int j = 0; j < pets[0].length; j++) {
                temp[i][j] = pets[i][j];
            }
        }
        for (int i = 0; i < 5; i ++) {
            temp[temp.length - 1][i] = newRow[i];
        }
        pets = temp;
    }


    public Pet selectPet(int row, int col) {
        return pets[row][col];
    }

    public String nameGen() {
        return names.get(1 + (int)(Math.random() * ((1177) + 1)));
    }

    public String genderGen() {
        if (1 + (int)(Math.random() * ((1) + 1)) == 2) {
            return "male";
        } else {
            return "female";
        }
    }

    public int priceGen() {
        return 1 + (int)(Math.random() * ((99) + 1));
    }

    public int ageGen() {
        return 1 + (int)(Math.random() * ((9) + 1));
    }

    public void printPets() {
        for (int i = 0; i < pets.length; i ++) {
            for (int j = 0; j < pets[0].length; j++) {
                if (j == 0 ) {
                    if (pets[i][j] instanceof Dog) {
                        System.out.print("D: ");
                    } else {
                        System.out.print("C: ");
                    }
                }
                System.out.print(pets[i][j].getName() + " ");
            }
            System.out.println();
        }
    }

    public void infections() {
       ArrayList<Pet> death = new ArrayList<Pet>();
        if (getTurns() <= 5) {
       } else if ((1 + (int)(Math.random() * ((4) + 1)) == 1)){
           for (Pet[] pet : pets) {
               for (int j = 0; j < pets[0].length; j ++) {
                   if (pet[j].isVaccinated()) {

                   } else if ((1  + (int)(Math.random() * ((99) + 1)) < turns * 3)){
                       death.add(pet[j]);
                   }
               }
           }
            for (int i = 0; i < death.size() - 1; i ++) {
                System.out.print(death.get(i).getName() + ", ");
            }
            System.out.print("and " + death.getLast().getName());
            System.out.println(" died");
       }
        for (int i = 0; i < pets.length; i ++) {
            for (int j = 0; j < pets[0].length; j ++) {
                if (death.contains(pets[i][j])) {
                    pets[i][j] = new Pet("gone", 0, false, "N/A", 0, 0);
                }
            }
        }
    }


    private void getNames() {
        try {
            File myFile = new File("src\\Names");
            Scanner fileScanner = new Scanner(myFile);
            while (fileScanner.hasNext()) {
                String data = fileScanner.nextLine();
                names.add(data);
            }
            System.out.println("\nNames.txt file imported successfully!");
            System.out.println(names);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove() {
        int count = 0;
        for (int i = 0; i < pets.length; i ++) {
            for (int j = 0; j < pets[0].length; j ++) {
                if (pets[i][j].getName().equals("gone")) {
                    count ++;
                }
            }
        }
        if (count >= 5) {
            int nrow = count/5;
            Pet[][] temp = new Pet[pets.length - nrow][5];
            int r = 0;
            int c = 0;
            for (int i = 0; i < pets.length; i ++) {
                for (int j = 0; j < pets[0].length; j ++) {
                    if (!pets[i][j].getName().equals("gone")) {
                        temp[r][c] = pets[i][j];
                        c ++;
                        if (c == 6) {
                            c = 0;
                            r ++;
                        }
                    }
                }
            }
            pets = temp;
        }
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getTurns() {
        return turns;
    }
}
