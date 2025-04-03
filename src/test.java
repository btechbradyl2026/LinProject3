import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        PetStore test = new PetStore(250);
        test.getNames();

        test.generatePet("dog");
        test.generatePet("cat");
        test.generatePet("dog");
        test.generatePet("cat");
        test.printPets();
        test.pets[0][2].setName("gone");
        test.pets[3][4].setName("gone");
        test.pets[2][3].setName("gone");
        test.pets[1][2].setName("gone");
        test.pets[0][1].setName("gone");
        test.pets[1][0].setName("gone");
        test.pets[3][2].setName("gone");
        test.pets[3][3].setName("gone");
        test.pets[2][1].setName("gone");
        test.pets[2][0].setName("gone");
        System.out.println(Arrays.deepToString(test.pets));
        test.remove();
        System.out.println(Arrays.deepToString(test.pets));
    }
}

