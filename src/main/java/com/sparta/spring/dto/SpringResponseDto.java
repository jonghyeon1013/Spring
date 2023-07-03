package com.sparta.spring.dto;

import com.sparta.spring.entity.Spring;
import lombok.Getter;

import javax.swing.*;
import java.time.LocalDateTime;

@Getter
public class SpringResponseDto {
    private Long id;
    private String username;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;



    public SpringResponseDto(Spring spring) {
        this.id = spring.getId();
        this.username = spring.getUsername();
        this.contents = spring.getContents();
        this.createdAt = spring.getCreatedAt();
        this.modifiedAt = spring.getModifiedAt();

    }

}
