package com.sparta.spring.controller;

import com.sparta.spring.dto.SpringRequestDto;
import com.sparta.spring.dto.SpringResponseDto;
import org.springframework.web.bind.annotation.*;
import com.sparta.spring.service.SpringService;
import com.sparta.spring.entity.Spring;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SpringController {

    private final SpringService springService;


    public SpringController(SpringService springService) {
        this.springService = springService;
    }


    @PostMapping("/spring")
    public SpringResponseDto createMemo(@RequestBody SpringRequestDto requestDto) {
        return springService.createSpring(requestDto);
    } // 게시글 작성 API

    @GetMapping("/spring")
    public List<SpringResponseDto> getSprings() {
        return springService.getSprings();
    } //전체 게시글 목록 조회 API

    @GetMapping("/spring/{id}")
    public Optional<Spring> getSpringById(@PathVariable Long id) {
        return springService.getSpringById(id);
    } //선택한 게시글 조회 API

    @PutMapping("/spring/{id}")
    public Long updateSpring(@PathVariable Long id, @RequestBody SpringRequestDto requestDto) {
        return SpringService.updateSpring(id, requestDto);
    } // 선택한 게시글 수정 API

    @DeleteMapping("/spring/{id}")
    public Long deleteSpring(@PathVariable Long id, @RequestBody SpringRequestDto requestDto) {
        return SpringService.deleteSpring(id);
    } // 선택한 게시글 삭제 API
}
