package demo.orchestration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import demo.orchestration.dto.RequestDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/search")
public class OrchController {
    
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
    private RestTemplate restTemplate;
    
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
