package com.example.lab4sentence.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 28, 2017
 */
@RestController
public class SentenceController
{
    @Autowired
    private DiscoveryClient client;

    @GetMapping("/sentence")
    public @ResponseBody String getSentence() {
        return getWord("LAB-4-SUBJECT") + " "
                + getWord("LAB-4-VERB") + " "
                + getWord("LAB-4-ARTICLE") + " "
                + getWord("LAB-4-ADJECTIVE") + " "
                + getWord("LAB-4-NOUN") + ".";
    }

    public String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0) {
            URI uri = list.get(0).getUri();
            System.out.println("URI: " + uri);
            if (uri != null) {
                return (new RestTemplate()).getForObject(uri, String.class);
            }
        }
        return null;
    }
}
