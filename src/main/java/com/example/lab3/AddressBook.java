package com.example.lab3;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_book_id")
    private List<BuddyInfo> buddies = new ArrayList<>();

    public AddressBook() {
        buddies = new ArrayList<>();
    }

    // Add a buddy
    public void addBuddy(BuddyInfo buddy) {
        if (buddy != null) {
            buddies.add(buddy);
        }
    }

    // Remove a buddy
    public void removeBuddy(BuddyInfo buddy) {
        buddies.remove(buddy);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Change 3: Return List instead of ArrayList
    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    // Change 4: Setter should accept List instead of ArrayList
    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    // List all buddies
    public void printBuddies() {
        for (BuddyInfo buddy : buddies) {
            System.out.println(buddy);
        }
    }
}