import models.Zoo;
import net.ravendb.client.documents.session.IDocumentSession;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarVisitorService {

    public static void save(IDocumentSession session) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj [id]:");
        String id = scanner.nextLine();

        System.out.println("Podaj nazwe zoo:");
        String title = scanner.nextLine();

        System.out.println("Podaj liczbe pracowników:");
        int numbers = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Podaj zwierze nr 1:");
        String an1 = scanner.nextLine();

        System.out.println("Podaj zwierze nr 2:");
        String an2 = scanner.nextLine();

        System.out.println("Podaj zwierze nr 3:");
        String an3 = scanner.nextLine();

        Zoo zoo = new Zoo(title, numbers, Arrays.asList(an1, an2, an3));
        session.store(zoo, id);
        session.saveChanges();
    }

    public static double findAverageWorkersNumberByName(IDocumentSession session) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj nazwe:");
        String title = scanner.nextLine();
        List<Zoo> result = session.query(Zoo.class)
                .whereEquals("title", title)
                .toList();

        double workersNumberAvg = result.stream().mapToDouble(Zoo::getWorkerNumbers).sum()/result.size();
        System.out.println("Srednia liczba praownikow zoo o nazwie: " + title + " wynosi: " + workersNumberAvg);
        return workersNumberAvg;
    }

    public static Zoo getById(IDocumentSession session) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj [id]:");
        String id = scanner.nextLine();

        Zoo result = session.load(Zoo.class, id);
        System.out.println(result);

        return result;
    }

    public static List<Zoo> getByTitle(IDocumentSession session) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe zoo:");
        String title = scanner.nextLine();

        List<Zoo> result = session.query(Zoo.class)
                .whereEquals("title", title)
                .toList();
        result.forEach(System.out::println);

        return result;
    }

    public static void deleteById(IDocumentSession session) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj [id]:");
        String id = scanner.nextLine();
        session.delete(id);
    }

    public static void update(IDocumentSession session) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj [id]:");
        String id = scanner.nextLine();

        System.out.println("Podaj nazwe zoo:");
        String title = scanner.nextLine();

        System.out.println("Podaj liczbe pracowników:");
        int numbers = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Podaj zwierze nr 1:");
        String an1 = scanner.nextLine();

        System.out.println("Podaj zwierze nr 2:");
        String an2 = scanner.nextLine();

        System.out.println("Podaj zwierze nr 3:");
        String an3 = scanner.nextLine();
        Zoo result = session.load(Zoo.class, id);

        result.setTitle(title);
        result.setWorkerNumbers(numbers);
        result.setAnimals(Arrays.asList(an1, an2, an3));
        session.saveChanges();
    }
}
