package com.fmi.demo.exposition.resources;


import com.fmi.demo.domain.model.Clothing;
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
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/clothing", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class ClothingResource {

    @Autowired
    private ICommand<Clothing> clothingICommand;

    @Autowired
    private IQuerry<Clothing> clothingIQuerry;

    @PostMapping("")
    public ResponseEntity<Clothing> createAuthor(@RequestBody Clothing author) throws Exception{
        String id= clothingICommand.save(author);
        final var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + id).toUriString();
        return ResponseEntity.created(new URI(uri))
                .body(clothingIQuerry.getById(id));
    }

    @PutMapping(path = "/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clothing> updateAuthor(@PathVariable("id") String id , @RequestBody Clothing clothing){
        String objectId= clothingICommand.update(clothing,id);
        return ResponseEntity.ok()
                .body(clothingIQuerry.getById(objectId));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Clothing> getAuthorById(@PathVariable("id") String id){
        return ResponseEntity.ok()
                .body(clothingIQuerry.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Clothing>> getAuthorById(){
        return ResponseEntity.ok()
                .body(clothingIQuerry.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") String id){
        clothingICommand.delete(id);
        return ResponseEntity.ok().build();
    }

}
