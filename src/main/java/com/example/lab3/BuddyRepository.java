package com.example.lab3;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuddyRepository extends JpaRepository<BuddyInfo, Long> {}

