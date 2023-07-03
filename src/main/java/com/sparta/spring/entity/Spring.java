package com.sparta.spring.entity;

import com.sparta.spring.dto.SpringRequestDto;
import com.sparta.spring.entity.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Getter
@Setter
@Table(name = "spring") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Spring extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;
    @Column(name = "title", nullable = false, length = 500)
    private String title;
    @Column(name = "pw")
    private int pw;

    public Spring(SpringRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.pw = requestDto.getPw();
    }

    public void update(SpringRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }
}