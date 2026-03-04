package net.bodkasoft.imagesgallery.service.impl;

import jakarta.persistence.PersistenceException;
import lombok.extern.slf4j.Slf4j;
import net.bodkasoft.imagesgallery.domain.author.Author;
import net.bodkasoft.imagesgallery.dto.author.AuthorDto;
import net.bodkasoft.imagesgallery.repository.AuthorRepository;
import net.bodkasoft.imagesgallery.repository.entity.AuthorEntity;
import net.bodkasoft.imagesgallery.service.AuthorService;
import net.bodkasoft.imagesgallery.service.exception.AuthorNotFoundException;
import net.bodkasoft.imagesgallery.service.mapper.AuthorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorMapper.toAuthorsList(authorRepository.findAll());
    }

    @Override
    public Author getAuthorById(UUID authorId) {
        AuthorEntity author = authorRepository.findById(authorId).orElseThrow(() -> {
            log.info("Author with id {} not found", authorId);
            return new AuthorNotFoundException(authorId);
        });

        return authorMapper.toAuthor(author);
    }

    @Override
    public Author createAuthor(AuthorDto author) {
        try {
            return authorMapper.toAuthor(authorRepository.save(authorMapper.toAuthorEntity(author)));
        } catch (Exception ex) {
            log.error("Exception occurred while creating author");
            throw new PersistenceException(ex);
        }
    }

    @Override
    public void deleteAuthorById(UUID authorId) {
        try {
            authorRepository.deleteById(authorId);
        } catch (Exception ex) {
            log.error("Exception occurred while deleting author with id {}", authorId);
            throw new PersistenceException(ex);
        }
    }
}
