package site.metacoding.dbproject.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class responseDto<T> {
    private Integer code;
    private T data;
    
}
