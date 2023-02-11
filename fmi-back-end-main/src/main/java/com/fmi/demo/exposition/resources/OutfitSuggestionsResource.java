package com.fmi.demo.exposition.resources;

import com.fmi.demo.domain.model.OutfitSuggestions;
import com.fmi.demo.domain.model.OutfitSuggestions;
import com.fmi.demo.exposition.ICommand.ICommand;
import com.fmi.demo.exposition.IQuerry.IQuerry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/outfitSuggestions", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j

public class OutfitSuggestionsResource {

    @Autowired
    private ICommand<OutfitSuggestions> outfitSuggestionsICommand;

    @Autowired
    private IQuerry<OutfitSuggestions> outfitSuggestionsIQuerry;

    @PostMapping("")
    public ResponseEntity<OutfitSuggestions> createAuthor(@RequestBody OutfitSuggestions author) throws Exception{
        String id= outfitSuggestionsICommand.save(author);
        final var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + id).toUriString();
        return ResponseEntity.created(new URI(uri))
                .body(outfitSuggestionsIQuerry.getById(id));
    }

    @PutMapping(path = "/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OutfitSuggestions> updateAuthor(@PathVariable("id") String id , @RequestBody OutfitSuggestions clothing){
        String objectId= outfitSuggestionsICommand.update(clothing,id);
        return ResponseEntity.ok()
                .body(outfitSuggestionsIQuerry.getById(objectId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OutfitSuggestions> getAuthorById(@PathVariable("id") String id){
        return ResponseEntity.ok()
                .body(outfitSuggestionsIQuerry.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") String id){
        outfitSuggestionsICommand.delete(id);
        return ResponseEntity.ok().build();
    }
}
