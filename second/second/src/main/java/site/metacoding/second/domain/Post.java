package site.metacoding.second.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//model

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    private String content;
}
