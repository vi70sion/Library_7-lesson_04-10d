public class Knyga {
    private String bookTitle, bookAuthor;
    private int yearPublished, readerID;

    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle;}
    public void setBookAuthor(String bookAuthor) { this.bookAuthor = bookAuthor;}
    public void setYearPublished(int yearPublished) { this.yearPublished = yearPublished;}
    public void setReaderID(int readerID) { this.readerID = readerID;}
    public String getBookTitle() { return bookTitle;}
    public int getReaderID() { return readerID;}

    public void setBook(String bookTitle, String bookAuthor, int yearPublished, int readerID){
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.yearPublished = yearPublished;
        this.readerID = readerID;
    }
    public void bookInfo(Knyga book){
        System.out.println(book.bookTitle + " " + bookAuthor + " " + yearPublished + " " + readerID);
    }


}
