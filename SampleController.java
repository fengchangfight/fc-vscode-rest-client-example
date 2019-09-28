package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/public/sample")
public class SampleController {

    @RequestMapping(method = RequestMethod.GET)
    public OuterSampleVO getSample() {
        return new OuterSampleVO(1L, new SampleVO(1L, "jet", "20190305"));
    }

    @PostMapping("/woho")
    public ResponseEntity<?> samplePost(SampleDTO req) {
        System.out.println(req);
        return new ResponseEntity<>("woho", HttpStatus.OK);
    }

    @GetMapping("/yoho")
    public ResponseEntity<?> sampleGet(@RequestParam("name") String name,
            @RequestParam("description") String description) {
        System.out.printf("My name is %s and my des is %s", name, description);
        return new ResponseEntity<>("******", HttpStatus.OK);

    }

    @PostMapping("/image")
    public ResponseEntity<?> uploadImageTest(@RequestParam("img") MultipartFile uploadFile,
            @RequestParam("text") String text) {
        System.out.println(text);
        System.out.println(uploadFile.getName());
        return new ResponseEntity<>("upload succeed", HttpStatus.OK);

    }

    @PostMapping("/multiple-images")
    public ResponseEntity<?> uploadMultipleImageTest(@RequestParam("img") List<MultipartFile> uploadFile,
            @RequestParam("text") String text) {
        System.out.println(text);
        for (MultipartFile f : uploadFile) {
            System.out.println(f.getName());
        }
        return new ResponseEntity<>("upload succeed", HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> bookDelete(@PathVariable("id") String id) {
        System.out.printf("Book id is : %s", id);
        return new ResponseEntity<>("book deleted", HttpStatus.OK);
    }
    @PutMapping("/book/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") String id, @RequestBody UpdateBookRequest req) {
        System.out.println(req.toString());
        System.out.printf("Book id to update: %s", id);
        return new ResponseEntity<>("book updated",HttpStatus.OK);
    }
}
