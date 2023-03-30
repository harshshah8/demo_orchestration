package demo.orchestration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class Myconfig {
    
    @Bean
    public RestTemplate restTemplate(){
        MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonHttpMessageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
        return restTemplate;
    }
}
