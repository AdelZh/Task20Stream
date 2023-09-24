import com.sun.jdi.event.StepEvent;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        List<Student> students = Arrays.asList(
                new Student("Alina", "Java 11", 18, 100),
                new Student("Elina", "Js", 20, 70),
                new Student("Adel", "Java 11", 20, 67),
                new Student("Malina", "Js", 18, 89));



        Scanner scanner=new Scanner(System.in);
        System.out.println("1. Delete duplicate words");
        System.out.println("2. Collect groups by groupName and age");
        System.out.println("3. Find average age of each group");
        System.out.println("4. Find average height of the groups");
        System.out.println("5. Collect groups by groupName");
        System.out.println("6. Find max age");
        System.out.println("7. Take only name from list of students");
        System.out.println("8. Join each separate name of students");
        System.out.println("9. Filter by age");
        System.out.println("10. Merge two list into one");
        System.out.println("11. Find longest word and put at first place");
        System.out.println("12. Sort unique words and transform them from list to treeSet");
        System.out.println("13. Transform the number of the list to -> x*2");
        System.out.println("14. Filter odd number");
        System.out.println("15. Filter distinct letters");
        System.out.println("16. Find the length of the word");
        System.out.println("17. Filter odd and even number in two separate list");
        System.out.println("18. Find the most longest number");
        System.out.println("19. Count number that less than 0");
        System.out.println("20. Find the pages of book");
        System.out.println("21. Collect the group by groupName and age using map");
        System.out.println("22. Find the sum of number");
        System.out.println("23. Count the distinct words of each sentence");
        System.out.println("24. Reverse the age of students");
        System.out.println("25. Exit");

        while (true){
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    List<String> sentence = Arrays.asList("Java Stream API is powerful.", "It simplifies data processing.", "Stream operations are versatile.");
                    List<String> distinctSentences = sentence
                            .stream()
                            .map(s -> s.split("\\s+"))
                            .flatMap(Arrays::stream)
                            .distinct()
                            .collect(Collectors.toList());

                    System.out.println(distinctSentences);
                    break;
                case 2:
                    System.out.println(students.stream()
                            .collect(Collectors.groupingBy(Student::getGroupName, Collectors.groupingBy(Student::getAge))));
                    break;
                case 3:
                    System.out.println(students.stream()
                        .collect(Collectors
                                .groupingBy(Student::getGroupName, Collectors
                                        .averagingDouble(Student::getAge))));
                break;
                case 4:
                    System.out.println(students.stream()
                            .collect(Collectors.averagingDouble(Student::getHeight)));
                    break;
                case 5:
                    System.out.println(students.stream()
                            .collect(Collectors
                                    .groupingBy(Student::getGroupName)));
                    break;
                case 6:
                    System.out.println(students.stream()
                            .max(Comparator.comparingInt(Student::getAge)).orElse(null));
                    break;
                case 7:
                    System.out.println(students.stream()
                            .map(Student::getName).collect(Collectors.toList()));
                    break;
                case 8:
                    String words=students.stream()
                            .map(Student::getName)
                            .collect(Collectors.joining());
                    System.out.println(words);
                    break;
                case 9:
                    System.out.println(students.stream()
                            .filter(s->s.getAge()>20).collect(Collectors.toList()));
                case 10:
                    List<Student> students1 = Arrays.asList(
                            new Student("Alina"),
                            new Student("Elina"),
                            new Student("Adell")
                    );

                    List<Student> students2 = Arrays.asList(
                            new Student("Alina1"),
                            new Student("Elina1"),
                            new Student("Adell1")
                    );

                    List<Student> newList = Stream.concat(students1.stream(), students2.stream()).toList();
                    System.out.println(newList);
                    break;
                case 11:
                    List<String> myList = Arrays.asList("apple", "banana", "cherry", "apple");

                    String longestWord = myList.stream()
                            .max(Comparator.comparingInt(String::length))
                            .orElse("");

                    List<String> reorderedList = myList.stream()
                            .filter(word -> !word.equals(longestWord))
                            .collect(Collectors.toList());

                    reorderedList.add(0, longestWord);

                    System.out.println(reorderedList);
                    break;
                case 12:
                    List<String> myList2 = Arrays.asList("apple", "banana", "cherry", "apple");
                    Set<String> uniqueWords = myList2.stream()
                            .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
                    System.out.println(uniqueWords);
                    break;
                case 13:
                    int size = 10;
                    int min = 1;
                    int max = 10;

                    List<Integer> randList = new Random().ints(size, min, max)
                            .boxed().map(r -> r * 2).toList();

                    System.out.println(randList);
                    break;
                case 14:
                    List<Integer> num = List.of(1, 2, 4, 6, 8);
                    List<Integer> num1 = num.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
                    System.out.println(num1);
                    break;
                case 15:
                    List<String> myList3=List.of("Java", "Java12", "Js");
                    List<Character> distinctLetters = myList3.stream()
                            .flatMap(s -> s.chars().mapToObj(c -> (char) c))
                            .distinct()
                            .collect(Collectors.toList());

                    System.out.println(distinctLetters);
                    break;
                case 16:
                    List<String> words1 = List.of("Java 11");

                    List<Integer> lengths = words1.stream()
                            .map(s -> s.replaceAll("\\s", ""))
                            .map(String::length)
                            .collect(Collectors.toList());

                    System.out.println(lengths);
                    break;
                case 17:
                    List<Integer> ll=List.of(1,2,4,7,8);
                    Map<Boolean, List<Integer>> lll2=ll.stream().collect(Collectors.partitioningBy(x->x%2==0));
                    List<Integer> oddNum=lll2.get(true);
                    List<Integer> evenNum=lll2.get(false);
                    System.out.println(oddNum);
                    System.out.println(evenNum);
                    break;
                case 18:
                    List<String> myList4=List.of("Java", "Java12", "Js");
                    System.out.println(myList4.stream().max(Comparator.comparingInt(String::length)).orElse(null));
                    break;
                case 19:
                    List<Integer> count=List.of(1,-1,2,3,-3);
                    System.out.println(count.stream().filter(x -> x < 0).count());
                    break;
                case 20:
                    List<Integer> collection = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        collection.add(i);
                    }
                    System.out.println(collection.stream().toList().subList(1, 3).stream().toList());
                    break;
                case 21:
                    List<Student> students22 = Arrays.asList(
                            new Student("Alina", "Java 11", 22, 100),
                            new Student("Elina", "Js", 20, 70),
                            new Student("Adel", "Java 11", 20, 67),
                            new Student("Malina", "Js", 18, 89));

                    Map<String, Map<Integer, List<Student>>> groupedStudents = students22.stream()
                            .collect(Collectors.groupingBy(Student::getName,
                                    Collectors.groupingBy(Student::getAge)));
                    System.out.println(groupedStudents);
                    break;
                case 22:
                    List<Integer> sum=List.of(1,2,3,4);
                    Integer sum1= sum.stream().mapToInt(Integer::intValue).sum();
                    System.out.println(sum1);
                    break;
                case 23:
                    List<String> sentence2 = Arrays.asList("Java Stream API is powerful.", "It simplifies data processing.", "Stream operations are versatile.");
                    System.out.println(sentence2.stream().map(s -> s.split("\\s+")).flatMap(Arrays::stream).count());
                    break;
                case 24:
                    System.out.println(students.stream()
                            .sorted(Comparator.comparingInt(Student::getAge).reversed()).collect(Collectors.toList()));
                    break;
                case 25:
                    System.exit(0);

            }
        }
























































    }
}

