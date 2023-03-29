package demo.orchestration.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequesDto {

    String Column;
    String Value;
    String joinTable;
    private Operation operation;

    public enum Operation{
        EQUAL,LIKE,IN,GREATER_THAN,LESS_THAN,BETWEEN,JOIN;
    }
    
}
