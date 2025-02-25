import java.io.*;
import java.util.*;

public class Main {

    static class Person {
        int age;
        String name;

        Person (int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Person[] persons = new Person[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            persons[i] = new Person(age, name);
        }

        Arrays.sort(persons, (o1, o2) -> o1.age - o2.age);

        StringBuilder sb = new StringBuilder();
        for (Person p : persons) {
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }
        System.out.println(sb);
    }
}
