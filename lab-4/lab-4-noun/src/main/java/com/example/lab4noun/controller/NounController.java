package com.example.lab4noun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 28, 2017
 */
@RestController
public class NounController
{
    @Value("${words}")
    private String words;

    @GetMapping("/")
    public @ResponseBody String getWord() {
        String[] wordArray = words.split(",");
        int i = (int) Math.round(Math.random() * (wordArray.length - 1));
        return wordArray[i];
    }
}