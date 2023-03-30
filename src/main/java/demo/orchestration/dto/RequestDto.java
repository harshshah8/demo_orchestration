package demo.orchestration.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RequestDto {

    private List<SearchRequesDto> searchRequesDto;
    private GlobalOperator globalOperator;

    public enum GlobalOperator{
        AND,OR;
    }
    
}
