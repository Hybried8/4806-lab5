package com.example.lab3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// This tells Spring Data JPA to create all the CRUD operations automatically
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
}
