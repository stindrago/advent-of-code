import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    int[] atLeast = new int[1000];
    int[] atMost = new int[1000];
    char[] letter = new char[1000];
    String[] password = new String[1000];
    int countPart1 = 0;
    int countPart2 = 0;

    try {
      File myObj = new File("../resource/input.txt");
      Scanner myReader = new Scanner(myObj);
      int line = 0;
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] arr = data.split(" ", 0);
        System.out.println("# Part 1");
        System.out.println("A: " + arr[0]);
        System.out.println("line: " + line);

        System.out.println("atLeast: " + arr[0].split("-", 0)[0]);
        atLeast[line] = Integer.parseInt(arr[0].split("-", 0)[0]);

        System.out.println("atMost: " + arr[0].split("-", 0)[1]);
        atMost[line] = Integer.parseInt(arr[0].split("-", 0)[1]);

        System.out.println("letter: " + arr[1].split(":", 0)[0]);
        letter[line] = arr[1].split(":", 0)[0].charAt(0);

        System.out.println("password: " + arr[2]);
        password[line] = arr[2];

        // Part 1
        System.out.println("Contains? " + password[line].contains(Character.toString(letter[line])));

        int count = 1;
        for (int i = 0; i < password[line].length(); i++)
          if (password[line].charAt(i) == letter[line])
            count++;

        if (count >= atLeast[line] && count <= atMost[line])
          countPart1++;

        // Part 2
        System.out.println("# Part 2");
        System.out.println("First:" + password[line].charAt(atLeast[line] - 1));
        System.out.println("Last:" + password[line].charAt(atMost[line] - 1));

        System.out.println("Equals? "
            + Character.toString(letter[line]).equals(Character.toString(password[line].charAt(atLeast[line] - 1))));

        if (Character.toString(letter[line]).equals(Character.toString(password[line].charAt(atLeast[line] - 1)))
            ^ (Character.toString(letter[line]).equals(Character.toString(password[line].charAt(atMost[line] - 1)))))
          countPart2++;
        line++;
      }
      System.out.println("Occurrences Part 1: " + countPart1);
      System.out.println("Occurrences Part 2: " + countPart2);

      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
