package demo.orchestration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.orchestration.dto.RequestDto;

@RestController
@RequestMapping("/search")
public class OrchController {

    @GetMapping("/health")
    public HttpStatus health()
    {
        return (HttpStatus.OK);
    }

    @PostMapping("/check")
    public HttpStatus check(@RequestBody RequestDto requestDto)
    {
        return(HttpStatus.OK);
    }
    
}
