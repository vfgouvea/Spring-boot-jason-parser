package com.jsonparser.controller;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jsonparser.model.Contact;
import com.jsonparser.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@CrossOrigin//para fazer chamada do mesmo host
@RestController
public class Controller {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/parseFile")
    public List<Contact> parseFile(@RequestParam("file") MultipartFile file) throws IOException {

        String fileName = fileStorageService.storeFile(file);

        File novoFile = new File(fileName);
        Gson gson = new Gson();
        List<Contact> contacts = gson.fromJson(new FileReader(novoFile), new TypeToken<List<Contact>>() {}.getType() );
        novoFile.delete();

        return contacts;

    }

}
