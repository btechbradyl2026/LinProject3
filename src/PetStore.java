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
        temp = pets.clone();
        temp[temp.length - 1] = newRow;
        pets = temp;
        System.out.println(Arrays.deepToString(pets));
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

}
