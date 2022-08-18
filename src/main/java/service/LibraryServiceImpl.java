package service;

import entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LibraryRepository;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public Library saveBook(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public List<Library> fetchBookList() {
        return (List<Library>) libraryRepository.findAll();
    }

    @Override
    public Library updateBook(Library library, Long bookId) {
        Library libraryFound = libraryRepository.findById(bookId).get();

        libraryFound.setBookName(library.getBookName());
        libraryFound.setBookWriter(library.getBookWriter());
        libraryFound.setBookPageCount(library.getBookPageCount());

        return libraryRepository.save(libraryFound);
    }

    @Override
    public void deleteBook(Long bookId) {
        libraryRepository.deleteById(bookId);
    }
}
