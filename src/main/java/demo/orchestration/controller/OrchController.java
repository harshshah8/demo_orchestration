package demo.orchestration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class OrchController {

    @GetMapping("/health")
    public HttpStatus health()
    {
        return (HttpStatus.OK);
    }
    
}
