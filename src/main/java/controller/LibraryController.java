package controller;

import entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.LibraryService;

import java.util.List;

@Controller
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @PostMapping("/departments")

    public Library saveDepartment(@RequestBody Library library) {
        return libraryService.saveBook(library);
    }

    @GetMapping("/departments")

    public List<Library> fetchDepartmentList() {
        return libraryService.fetchBookList();
    }

    @PutMapping("/departments/{id}")

    public Library
    updateDepartment(@RequestBody Library library,
                     @PathVariable("id") Long departmentId) {
        return libraryService.updateBook(
                library, departmentId);
    }

    @DeleteMapping("/departments/{id}")

    public String deleteDepartmentById(@PathVariable("id")
                                       Long departmentId) {
        libraryService.deleteBook(departmentId);
        return "Deleted Successfully";
    }

}
