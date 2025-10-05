package com.example.lab3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/buddies")
public class BuddyController {

    private final BuddyRepository repo;

    public BuddyController(BuddyRepository repo) {
        this.repo = repo;
    }

    // ✅ JSON endpoint
    @GetMapping
    @ResponseBody
    public List<BuddyInfo> getAll() {
        return repo.findAll();
    }

    // ✅ JSON POST
    @PostMapping
    @ResponseBody
    public BuddyInfo create(@RequestBody BuddyInfo buddy) {
        return repo.save(buddy);
    }

    // ✅ JSON DELETE
    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteBuddy(@PathVariable Long id) {
        repo.deleteById(id);
    }

    // ✅ Thymeleaf endpoint (GUI)
    @GetMapping("/view")
    public String listBuddies(Model model) {
        model.addAttribute("buddies", repo.findAll());
        return "buddies"; // looks for templates/buddies.html
    }
}
