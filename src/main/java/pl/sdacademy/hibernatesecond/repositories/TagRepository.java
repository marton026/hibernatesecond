package pl.sdacademy.hibernatesecond.repositories;

import pl.sdacademy.hibernatesecond.entities.Tag;

import javax.persistence.EntityManager;
import java.util.List;

// TODO: klasa repozytorium
public class TagRepository {

    // TODO: konteks utrwalania
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
