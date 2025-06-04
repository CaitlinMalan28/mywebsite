package za.co.shinysneaker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(path={"/", "/root"})
    public String root(){
        return "<i>Root Connected</i>";
    }
}
