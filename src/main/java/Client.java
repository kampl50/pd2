import models.Zoo;
import net.ravendb.client.documents.session.IDocumentSession;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            {
                Scanner scanner = new Scanner(System.in);
                int select;
                do {
                    System.out.println("[0]wyjscie\t\t[1]dodaj zoo\t\t[2]usun zoo\t\t[3]znajdz po id\t\t[4]aktualizuj zoo\t\t[5]zwroc po nazwie\t\t" +
                            "[6]srednia liczba pracownikow zoo po nazwie\\t\"");
                    select = scanner.nextInt();
                    switch (select) {
                        case 0:
                            break;
                        case 1:
                            CarVisitorService.save( session);
                            break;
                        case 2:
                            CarVisitorService.deleteById( session);
                            break;
                        case 3:
                            CarVisitorService.getById( session);
                            break;
                        case 4:
                            CarVisitorService.update( session);
                            break;
                        case 5:
                            CarVisitorService.getByTitle( session);
                            break;
                        case 6:
                            CarVisitorService.findAverageWorkersNumberByName( session);
                            break;
                        default:
                            throw new IllegalStateException("Nie ma takiej opcji pod tym numerem: " + select);
                    }
                } while (select != 0);

            }
        }

    }
}
