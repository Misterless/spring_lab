package site.metacoding.dbproject.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class User { 
//jpalib Java Persistence API
//CRUD Method 
//DB Auto generation by Javacode
//ORM offer

@Id
@GeneratedValue(strategy =  GenerationType.IDENTITY)
//identity 전략은 DB에게 번호증가 전략을위임하는것
    private Integer id; //primary key

    @Column(length= 20, unique = true)
    private String username; //id
    @Column(length=12, nullable =  false)
    private String password;
    @Column (length=16000000)
    private String email;
    
    private LocalDateTime createDate;
     
}
