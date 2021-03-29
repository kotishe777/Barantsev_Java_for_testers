package learn_java.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {
    //String [] langs = {"Java","C#","Python","PHP"};
    String[] langs = new String[4];
    langs[0] = "Java";
    langs[1] = "C#";
    langs[2] = "Python";
    langs[3] = "PHP";

    List<String> langs2 = new ArrayList<String>();
    langs2.add("Java");
    langs2.add("C#");
    langs2.add("Python");
    langs2.add("PHP");

    String [] langs3 = {"Java","C#","Python","PHP"};
    List <String> langs4 = Arrays.asList("Java","C#","Python","PHP");

    for (int i = 0; i < langs.length; i++) {
      System.out.println("I want to learn " + langs[i]);
    }

    for (String s : langs) {
      System.out.println("I want to learn " + s);
    }

    for (String s : langs2) {
      System.out.println("I want to learn " + s);
    }

    for (int i = 0; i < langs4.size(); i++) {
      System.out.println("I want to learn " + langs4.get(i));
    }
  }

}
