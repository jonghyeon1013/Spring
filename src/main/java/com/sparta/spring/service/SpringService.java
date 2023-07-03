package com.sparta.spring.service;

import com.sparta.spring.dto.SpringRequestDto;
import com.sparta.spring.dto.SpringResponseDto;
import com.sparta.spring.entity.Spring;
import com.sparta.spring.repository.SpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SpringService {

    private final SpringRepository springRepository;

    public List<SpringResponseDto> getSprings() {
        return springRepository.findAllByOrderByModifiedAtDesc().stream().map(SpringResponseDto::new).toList();
    }

    public SpringResponseDto createSpring(SpringRequestDto requestDto) {

        Spring spring = new Spring(requestDto);
        Spring saveSpring = springRepository.save(spring);
        return new SpringResponseDto(saveSpring);
    }

    public SpringResponseDto findSpringResponse(Long id) {
        Spring spring = findSpring(id);
        return new SpringResponseDto(spring);
    }

    public SpringResponseDto updateSpring(Long id, SpringRequestDto requestDto) {
        Spring spring = findSpring(id);

        if(spring.getPw().equals(requestDto.getPw())){
            spring.update(requestDto);
            return new SpringResponseDto(spring);
        } else {
            throw new IllegalArgumentException("비밀번호를 잘못 입력했습니다.");
        }
    }

    public Boolean deleteSpring(Long id, String pw){
        Spring spring = findSpring(id);
        if (spring.getPw().equals(pw)) {
            springRepository.delete(spring);
            return true;
        } else {
            return false;
        }
    }


        private Spring findSpring (Long id) {
            return springRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"게시글이 존재하지 않습니다.")
            );
        }
    }