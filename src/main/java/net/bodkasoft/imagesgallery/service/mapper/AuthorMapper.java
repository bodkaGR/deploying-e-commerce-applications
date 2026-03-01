package net.bodkasoft.imagesgallery.service.mapper;

import net.bodkasoft.imagesgallery.domain.author.Author;
import net.bodkasoft.imagesgallery.dto.author.AuthorDto;
import net.bodkasoft.imagesgallery.dto.author.AuthorEntry;
import net.bodkasoft.imagesgallery.dto.author.AuthorListDto;
import net.bodkasoft.imagesgallery.repository.entity.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toAuthor(AuthorEntity authorEntity);

    AuthorEntity toAuthorEntity(AuthorDto author);

    AuthorDto toAuthorDto(Author author);

    default AuthorListDto toAuthorListDto(List<Author> authors) {
        return AuthorListDto.builder().authorEntries(toAuthorsEntry(authors)).build();
    }

    List<AuthorEntry> toAuthorsEntry(List<Author> authors);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    AuthorEntry toAuthorEntry(Author author);

    List<Author> toAuthorsList(List<AuthorEntity> authorEntities);
}
