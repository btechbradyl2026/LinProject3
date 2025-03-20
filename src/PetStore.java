import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PetStore {
    int money;
    ArrayList<String> names = new ArrayList<String>();
    Pet[][] pets;
    int turns;
    Scanner scan = new Scanner(System.in);

    public PetStore (int money) {
        this.money = money;
        turns = 0;
    }

    public void loop () {
        while (money < 1000) {
            System.out.println("Menu: ");
            System.out.println("(P)rint pets");
            System.out.println("(G)enerate 5 new pets (Costs 50 dollars)");
            System.out.println("(V)accinate a row of pets (Costs 25 dollars)");
            System.out.println("Your current balance is " + money);
            if (scan.nextLine().equals("P")) {
                printPets();
            } else if (scan.nextLine().equals("G")) {
                System.out.println("cats or dogs?");
                generatePet(scan.nextLine());
            } else if (scan.nextLine().equals("V")) {

            }
        }
    }

    public void welcome() {
        System.out.println("Hello and welcome to PetManagerCo!");
        System.out.println("Your goal is to make a thousand dollars of profit in the fewest turns possible!");
        loop();
    }

    public void generatePet(String cd) {
        Pet currentPet;
        Pet[] newRow = new Pet[5];
        for (int i = 0; i < 5; i ++) {
            if (cd.equals("cat")) {
                int price = priceGen();
                double want = ((double) price/100 - 100) * -1;
                currentPet = new Cat(nameGen(), ageGen(), false ,genderGen(), price, want);
            } else if (cd.equals("dog")) {
                int price = priceGen();
                double want = ((double) price/100 - 100) * -1;
                currentPet = new Dog(nameGen(), ageGen(), false ,genderGen(), price, want);
            } else {
                System.out.println("Please enter \"cat\" or \"dog\" in the second slot");
                break;
            }
            newRow[i] = currentPet;
        }
        Pet[][] temp = new Pet[pets.length + 1][5];
        setMoney(getMoney() - 50);
        temp = pets.clone();
        temp[temp.length - 1] = newRow;
        pets = temp;
        System.out.println(Arrays.deepToString(pets));
    }


    public void sellPet(int row, int col) {

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
        return 1 + (int)(Math.random() * ((14) + 1));
    }

    public void printPets() {
        for (Pet[] pet : pets) {
            for (int j = 0; j < pets[0].length; j++) {
                System.out.print(pet[j].getName());
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

                   } else if ((1  + (int)(Math.random() * ((99) + 1)) < turns * 2)){
                       death.add(pet[j]);
                       pet[j] = null;
                   }
               }
           }
            for (int i = 0; i < death.size() - 1; i ++) {
                System.out.print(death.get(i).getName() + ", ");
            }
            System.out.print(death.get(death.size()- 1).getName());
       }
    }

    private void getNames() {
        try {
            File myFile = new File("src\\Names.txt");
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
