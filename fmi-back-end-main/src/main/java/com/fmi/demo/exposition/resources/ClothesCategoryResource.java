package com.fmi.demo.exposition.resources;

import com.fmi.demo.domain.model.ClothesCategory;
import com.fmi.demo.domain.model.ClothesCategory;
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
@RequestMapping(value = "/api/v1/ClothesCategoryCategory", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class ClothesCategoryResource {

    @Autowired
    private ICommand<ClothesCategory> clothesCategoryICommand;

    @Autowired
    private IQuerry<ClothesCategory> clothesCategoryIQuerry;


    @PostMapping("")
    public ResponseEntity<ClothesCategory> createAuthor(@RequestBody ClothesCategory author) throws Exception{
        String id= clothesCategoryICommand.save(author);
        final var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + id).toUriString();
        return ResponseEntity.created(new URI(uri))
                .body(clothesCategoryIQuerry.getById(id));
    }

    @PutMapping(path = "/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClothesCategory> updateAuthor(@PathVariable("id") String id , @RequestBody ClothesCategory ClothesCategory){
        String objectId= clothesCategoryICommand.update(ClothesCategory,id);
        return ResponseEntity.ok()
                .body(clothesCategoryIQuerry.getById(objectId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClothesCategory>> getAuthorById(){
        return ResponseEntity.ok()
                .body(clothesCategoryIQuerry.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") String id){
        clothesCategoryICommand.delete(id);
        return ResponseEntity.ok().build();
    }
}
