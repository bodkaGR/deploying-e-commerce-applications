package net.bodkasoft.imagesgallery.web;

import jakarta.validation.Valid;
import net.bodkasoft.imagesgallery.dto.author.AuthorDto;
import net.bodkasoft.imagesgallery.dto.author.AuthorListDto;
import net.bodkasoft.imagesgallery.service.AuthorService;
import net.bodkasoft.imagesgallery.service.mapper.AuthorMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.ResponseEntity.noContent;

@RestController
@Validated
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    public AuthorController(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @GetMapping
    public ResponseEntity<AuthorListDto> getAllAuthors() {
        return ResponseEntity.ok(authorMapper.toAuthorListDto(authorService.getAllAuthors()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable UUID id) {
        return ResponseEntity.ok(authorMapper.toAuthorDto(authorService.getAuthorById(id)));
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody @Valid AuthorDto authorDto) {
        return ResponseEntity.ok(authorMapper.toAuthorDto(authorService.createAuthor(authorDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthorById(@PathVariable UUID id) {
        authorService.deleteAuthorById(id);
        return noContent().build();
    }
}
