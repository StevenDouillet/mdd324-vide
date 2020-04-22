package com.ipiecoles.java.mdd324.homepage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actus")
public class ActuController {

    @Autowired
    private ActuService actuService;

    @GetMapping
    public List<Item> getActus() {
        return actuService.getActus();
    }
}
