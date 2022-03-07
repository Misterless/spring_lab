package site.metacoding.dbproject.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
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
    @CreatedDate//insert
    private LocalDateTime createDate;
    @LastModifiedDate //insert&update
    private LocalDateTime updateDate;
}
