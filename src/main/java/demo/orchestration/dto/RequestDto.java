package demo.orchestration.dto;

import java.util.List;

public class RequestDto {

    private List<SearchRequesDto> searchRequesDto;
    private GlobalOperator globalOperator;

    public enum GlobalOperator{
        AND,OR;
    }
    
}
