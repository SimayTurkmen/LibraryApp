package service;

import entity.Library;

import java.util.List;

public interface LibraryService {
    Library saveBook(Library library);

    List<Library> fetchBookList();

    Library updateBook(Library library, Long bookId);

    void deleteBook(Long bookId);

}
