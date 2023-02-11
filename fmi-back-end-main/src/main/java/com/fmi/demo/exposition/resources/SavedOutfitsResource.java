package com.fmi.demo.exposition.resources;

import com.fmi.demo.domain.model.SavedOutfits;
import com.fmi.demo.domain.model.SavedOutfits;
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
@RequestMapping(value = "/api/v1/savedOutfits", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class SavedOutfitsResource {

    @Autowired
    private ICommand<SavedOutfits> savedOutfitsICommand;

    @Autowired
    private IQuerry<SavedOutfits> savedOutfitsIQuerry;

    @PostMapping("")
    public ResponseEntity<SavedOutfits> createAuthor(@RequestBody SavedOutfits author) throws Exception{
        String id= savedOutfitsICommand.save(author);
        final var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + id).toUriString();
        return ResponseEntity.created(new URI(uri))
                .body(savedOutfitsIQuerry.getById(id));
    }

    @PutMapping(path = "/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SavedOutfits> updateAuthor(@PathVariable("id") String id , @RequestBody SavedOutfits clothing){
        String objectId= savedOutfitsICommand.update(clothing,id);
        return ResponseEntity.ok()
                .body(savedOutfitsIQuerry.getById(objectId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavedOutfits> getAuthorById(@PathVariable("id") String id){
        return ResponseEntity.ok()
                .body(savedOutfitsIQuerry.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") String id){
        savedOutfitsICommand.delete(id);
        return ResponseEntity.ok().build();
    }

}
