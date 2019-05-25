package pl.sdacademy.hibernatesecond.repositories;

import org.springframework.stereotype.Repository;
import pl.sdacademy.hibernatesecond.entities.Tag;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TagRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addTag(Tag tag) {
        // TODO: metoda dodaje nowy tag
    }

    public List<Tag> findAllTags() {
        // TODO: wyszukuje wszystkie tagi
        return null;
    }

    public List<Tag> findTagById(Long tagId) {
        // TODO: wyszukuje tag po id
        return null;
    }

    public Tag modifyTagName(Long tagId, String newTagName) {
        // TODO: modyfikuje tagName dla obiektu o podanym id
        return null;
    }

    public void deleteTagById(Long tagId) {
        // TODO: usuwa obiekt o podanym id
    }


}
