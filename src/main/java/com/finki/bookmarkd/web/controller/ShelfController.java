package com.finki.bookmarkd.web.controller;

import com.finki.bookmarkd.model.User;
import com.finki.bookmarkd.model.UserBook;
import com.finki.bookmarkd.model.readingStatus;
import com.finki.bookmarkd.service.UserBookService;
import java.util.ArrayList;
import org.h2.engine.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/shelves")
public class ShelfController {

    private final UserBookService userBookService;

    public ShelfController(UserBookService userBookService) {
        this.userBookService = userBookService;
    }

    @GetMapping()
    public String getShelves(Model model){

        model.addAttribute("toReadBooks", this.userBookService.listByStatus(readingStatus.TO_READ));
        model.addAttribute("readBooks", this.userBookService.listByStatus(readingStatus.READ));
        model.addAttribute("readingBooks", this.userBookService.listByStatus(readingStatus.READING));

        return "shelves";
    }

    @PostMapping("/{userBookId}/delete")
    public String deleteUserBook(@PathVariable Long userBookId){
        this.userBookService.deleteBookOnShelf(userBookId);
        return "redirect:/shelves";
    }

    @PostMapping("/{userBookId}/save")
    public String updateUserBook(@PathVariable Long userBookId,
                                 @RequestParam (required = false) readingStatus readingStatus,
                                 @RequestParam (required = false) Integer rating,
                                 @RequestParam (required = false) String startedDate,
                                 @RequestParam (required = false) String completedDate){

        this.userBookService.updateBookShelf(userBookId,readingStatus, rating, LocalDate.parse(startedDate), LocalDate.parse(completedDate));
        return "redirect:/shelves";
    }

    @GetMapping("/{userBookId}/update")
    public String updateUserBookPage(@PathVariable Long userBookId, Model model){
        UserBook userBook = this.userBookService.findById(userBookId);
        model.addAttribute("userBook", userBook);
        model.addAttribute("toReadBooks", this.userBookService.listByStatus(readingStatus.TO_READ));
        model.addAttribute("readBooks", this.userBookService.listByStatus(readingStatus.READ));
        model.addAttribute("readingBooks", this.userBookService.listByStatus(readingStatus.READING));

        List<readingStatus> statuses = new ArrayList<>();
        readingStatus toRead = readingStatus.TO_READ;
        readingStatus read = readingStatus.READ;
        readingStatus reading = readingStatus.READING;
        statuses.add(read);
        statuses.add(reading);
        statuses.add(toRead);
        model.addAttribute("statuses", statuses);

        return "editUserBook";
    }

}
