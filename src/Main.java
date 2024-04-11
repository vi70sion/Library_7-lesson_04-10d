import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Parašykite programą, kuri simbolizuotų biblioteką.
//        Sukurkite klasę Knyga, kurioje yra šie atributai: pavadinimas, autorius, leidimo metai ir paskutinio
//        skaitytojo ID (galite panaudoti int tipo kintamąjį). Nustatykite pavadinimo,
//        autoriaus ir leidimo metų laukus kaip private, o skaitytojo ID lauką kaip private.
//        Sukurkite reikiamus getterius ir setterius.
//
//        Taip pat, parašykite metodą grąžinimui knygos informacijos ekrane, kuris pateiktų visą knygos informaciją.
//
//        Sukurkite klasę Biblioteka, kurioje yra sąrašas su knygomis.
//        Sukurkite metodus, kurie leistų pridėti naujas knygas į biblioteką ir pasiimti knygą iš bibliotekos, priskirdami
//        jai skaitytojo ID.
//
//        Pagrindiniame kode sukurkite kad vartotojas galėtų įvesti naujas knygas į biblioteką ir pasiimti
//        knygą pagal pavadinimą, atspausdindamas knygos informaciją.
//        Taip pat įtraukite exception handling, kad vartotojas būtų informuotas, jei knyga nėra bibliotekoje
//        arba jei nepavyksta tinkamai įvesti duomenų.

        Scanner scanner = new Scanner(System.in);
        String choice = "";
        do{
            System.out.println("Pasirinkite veiksma: ");
            System.out.println("(1)- prideti knyga, (2)- prideti knyga i biblioteka, (3)- pasiimti knyga is bibliotekos, (0)- pabaiga");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    Knyga book = new Knyga();
                    System.out.println("Iveskite nauja knyga: (pavadinimas), (autorius), (leidimo metai) :");
                    book.setBookTitle(scanner.nextLine());
                    book.setBookAuthor(scanner.nextLine());
                    book.setYearPublished(scanner.nextInt());
                    book.setReaderID(0); // id is 0, no one reader has didn't take the book yet
                    System.out.print("Jusu naujai ivesta knyga yra: ");
                    book.bookInfo(book); //show book info
                    scanner.nextLine();
                    System.out.println();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Neteisingas pasirinkimas, bandykite dar karta.");
            }
        }while(!choice.equals("0"));


        scanner.close();

    }
}