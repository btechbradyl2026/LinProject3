import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PetStore {

    int money;
    ArrayList<String> names = new ArrayList<String>();
    Pet[][] pets;
    int turns;


    public void generatePet(int pets, String cd) {
        Pet currentPet;
        for (int i = 0; i < pets; i ++) {
            if (cd.equals("cat")) {

            } else if (cd.equals("dog")) {
                currentPet = new Dog(nameGen(), ageGen(), )
            } else {
                System.out.println("Please enter \"cat\" or \"dog\" in the second slot");
                break;
            }
        }
    }

    public String nameGen() {
        return names.get(1 + (int)(Math.random() * ((1177) + 1)));
    }

    public int ageGen() {
        return 1 + (int)(Math.random() * ((14) + 1));
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
