import java.util.ArrayList;
import java.util.List;

public class Biblioteka {
    private List<Knyga> bookList = new ArrayList<Knyga>();

    public List<Knyga> getBookList() {
        return bookList;
    }

    public void addBookToList(Knyga book){
        this.bookList.add(book);
    }

    public void getBookFromList(){

    }

}
