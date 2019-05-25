package pl.sdacademy.hibernatesecond.controllers;

import org.springframework.web.bind.annotation.RestController;
import pl.sdacademy.hibernatesecond.repositories.TagRepository;


@RestController
public class TagController {

   private TagRepository tagRepository;

    public TagController(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
}
