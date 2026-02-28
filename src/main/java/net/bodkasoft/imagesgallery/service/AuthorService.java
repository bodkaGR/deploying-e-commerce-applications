package net.bodkasoft.imagesgallery.service;

import net.bodkasoft.imagesgallery.domain.author.Author;
import net.bodkasoft.imagesgallery.dto.author.AuthorEntryDto;

import java.util.List;
import java.util.UUID;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthorById(UUID id);

    Author createAuthor(AuthorEntryDto author);

    void deleteAuthorById(UUID id);

}
