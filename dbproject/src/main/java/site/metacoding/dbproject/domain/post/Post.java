package site.metacoding.dbproject.domain.post;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.dbproject.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)

public class Post {
    
    @Id
@GeneratedValue(strategy =  GenerationType.IDENTITY)
//identity 전략은 DB에게 번호증가 전략을위임하는것
    private Integer id; //primary key

    @Column(length= 300, nullable = false)
    private String title; //id
    @Lob
    @Column( nullable =  false)
    private String content;

    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;
    //private Integer userId;

    @CreatedDate//insert
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime updateDate;
}
