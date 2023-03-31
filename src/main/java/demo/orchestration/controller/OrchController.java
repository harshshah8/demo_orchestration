package demo.orchestration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import demo.orchestration.dto.RequestDto;
import demo.orchestration.dto.UserData;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/search")
public class OrchController {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/health")
    public HttpStatus health()
    {
        return (HttpStatus.OK);
    }

    @PostMapping("/check")
    public ResponseEntity<RequestDto> check(@RequestBody RequestDto requestDto)
    {
        //System.out.println(requestDto.toString());
        return new ResponseEntity<>(requestDto,HttpStatus.OK);

    }

    @PostMapping("/searchspecification")
    public ResponseEntity<String> getSearchSpecification(@RequestBody RequestDto requestDto)
    {
        String endpoint = "http://localhost:9091/filter/dynamicspecification";
        System.out.println(requestDto.toString());
        ResponseEntity<String> response = restTemplate.postForEntity(endpoint, requestDto,String.class);
        return response;
    }
    
}
