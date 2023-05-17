package HomeWork.byBook;

import java.util.List;
import java.util.Map;

public class GetAuthorByBook {
    public String getAuthorNameByBookTitle(Map<Author, List<Book>> authorBooks, String bookTitle) {
        for (Map.Entry<Author, List<Book>> listOfBooks : authorBooks.entrySet()) {
            for (Book book : listOfBooks.getValue()){
                if (book.getTitle().equals(bookTitle)){
                    return listOfBooks.getKey().getName();
                }
            }
        }
        return null;
    }
}

