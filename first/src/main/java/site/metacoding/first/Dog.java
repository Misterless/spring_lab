package site.metacoding.first;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Dog {
    private String name ="푸들";
    
    public Dog() {
        System.out.println("푸들이 IoC 컨테이너에 등록되었어요");
    }
}
