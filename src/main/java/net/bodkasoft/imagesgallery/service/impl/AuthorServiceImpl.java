package net.bodkasoft.imagesgallery.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bodkasoft.imagesgallery.domain.author.Author;
import net.bodkasoft.imagesgallery.dto.author.AuthorEntryDto;
import net.bodkasoft.imagesgallery.repository.AuthorRepository;
import net.bodkasoft.imagesgallery.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return List.of();
    }

    @Override
    public Author getAuthorById(UUID id) {
        return null;
    }

    @Override
    public Author createAuthor(AuthorEntryDto author) {
        return null;
    }

    @Override
    public void deleteAuthorById(UUID id) {

    }
}
