package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LuckyWordController
{

    @Value("${lucky-word}")
    String luckyWord;
    @Value("${hello}")
    String hello;

    @GetMapping("/lucky-word")
    public String showLuckyWord() {
        return "The lucky word is: " + luckyWord;
    }

    @GetMapping("/hello")
    public String showHello() {
        return "The greeting is: " + hello;
    }
}
