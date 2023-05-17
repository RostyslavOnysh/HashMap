# Task 

Find and return the author's name, according to the title of the book he wrote. 
If there is no such book - return null.
To do this, implement the method 
public String getAuthorNameByBookTitle(Map<Author, List<Book>> authorBooks, String bookTitle),
### which has following parameters:
* Map<Author, List<Book>> authorBooks - information about the author and his books
* String bookTitle - book title

### My explaining :
At first glance, you need to iterate through all the objects in the map.
Then, check each entry to find the author based on the book title.
If the title matches, output the author's name; otherwise, return null.

The *getAuthorNameByBookTitle* code has the correct structure to solve the given task. 
I ***iterate*** over the entries in *authorBooks (Map.Entry<Author, List<Book>>)*,
and then check each book in ***listOfBooks.getValue()***.
If the book title matches *bookTitle*, you return the author's name using ***listOfBooks.getKey().getName()***~~~~. 
If there is no book with such a title, you return null.


## Here is the second variand to solve this task :
```java 
public class GetAuthorByBook {
public String getAuthorNameByBookTitle(Map<Author, List<Book>> authorBooks, String bookTitle) {
/*
iterate through every element in map using entrySet()
because we don't know nor keys nor values that map contains
*/
for (Map.Entry<Author, List<Book>> entry : authorBooks.entrySet()) {
// variable for storing books of current author
List<Book> books = entry.getValue();
// iterate through every element in list
for (Book book : books) {
// check if current element's title equals to target one
if (book.getTitle().equals(bookTitle)) {
// in case if we found needed book we return author's name
return entry.getKey().getName();
}
}
}
// in case if we can't find author's name return null
return null;
}
}
```
