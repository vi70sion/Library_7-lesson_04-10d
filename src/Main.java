import java.sql.SQLOutput;
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
        Knyga book = new Knyga();
        Biblioteka library = new Biblioteka();
        String title; //title of the book you are looking for
        int identification = 0; // reader ID
        boolean foundBook;
        String choice = "";
        do{
            System.out.println("Pasirinkite veiksmą: ");
            System.out.println("(1)- pridėti knygą, (2)- pridėti knygą į biblioteką, (3)- pasiimti knygą iš bibliotekos,");
            System.out.println("(4)- grąžinti knygą, (0)- pabaiga");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    book = new Knyga();
                    System.out.println("Įveskite naują knygą: (pavadinimas), (autorius), (leidimo metai) :");
                    book.setBookTitle(scanner.nextLine());
                    book.setBookAuthor(scanner.nextLine());
                    book.setYearPublished(scanner.nextInt());
                    book.setReaderID(0); // id is 0, no one reader has didn't take the book yet
                    System.out.print("Jusu naujai įvesta knyga yra: ");
                    book.bookInfo(book); //show book info
                    scanner.nextLine();
                    System.out.println();
                    break;
                case "2":
                    if (book.getBookTitle() == null) {
                        System.out.println("Knyga dar neįvesta."); // book title is empty
                        break;
                    }
                    //need to check is the book already in the library list
                    //library.addBookToList(book);
                    library.getBookList().add(book);
                    System.out.println("Knyga sėkmingai pridėta į bibliotekos sąrašą.");
                    break;
                case "3":
                    foundBook = false;
                    System.out.println("Įveskite savo skaitytojo ID numerį: ");
                    identification = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Įveskite norimos knygos pavadinimą: ");
                    title = scanner.nextLine();
                    for (Knyga wantedBook : library.getBookList()){
                        if(wantedBook.getBookTitle().equals(title)){ //search for book by title
                            foundBook = true;
                            System.out.println("Radome jūsų knygą: ");
                            if(wantedBook.getReaderID() == 0){  // if id=0, book in the library
                                wantedBook.setReaderID(identification);
                                wantedBook.bookInfo(wantedBook);
                                break;
                            } else {
                                System.out.println("Jūsų ieškomą knygą šiuo metu skaito kitas klientas, atsiprašome.");
                            }
                            break;
                        }
                    }

                    if(!foundBook) {
                        System.out.println("Neradome jūsų ieškomos knygos.");
                    }
                    break;
                case "4":
                    foundBook = false;
                    System.out.println("Įveskite grąžinamos knygos pavadinimą: ");
                    title = scanner.nextLine();
                    for (Knyga wantedBook : library.getBookList()){
                        if(wantedBook.getBookTitle().equals(title)){ //search for book by title
                            foundBook = true;
                            System.out.println("Radome jūsų knygą: ");
                            if(wantedBook.getReaderID() != 0){  // if id=0, book in the library
                                wantedBook.setReaderID(0); //after return, the book is not assigned to any ID
                                wantedBook.bookInfo(wantedBook);
                                break;
                            } else {
                                System.out.println("Jūsų ieškoma knyga jau grąžinta.");
                            }
                            break;
                        }
                    }
                    if(!foundBook) {
                        System.out.println("Neradome jūsų ieškomos knygos.");
                    }
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Neteisingas pasirinkimas, bandykite dar kartą.");
            }
        }while(!choice.equals("0"));


        scanner.close();

    }
}