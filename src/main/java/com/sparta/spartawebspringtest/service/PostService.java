package com.sparta.spartawebspringtest.service;


import com.sparta.spartawebspringtest.dto.MessageDto;
import com.sparta.spartawebspringtest.dto.PostDto;
import com.sparta.spartawebspringtest.entity.ItemEntity;
import com.sparta.spartawebspringtest.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final ItemRepository itemRepository;


    public PostDto.Response createPost(PostDto.Request dto) {
        ItemEntity item = ItemEntity.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .price(dto.getPrice())
                .username(dto.getUsername())
                .build();

        itemRepository.save(item);

        return PostDto.Response.builder()
                .id(item.getId())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .username(item.getUsername())
                .build();
    }

    public List<PostDto.Response> getPosts() {
        List<ItemEntity> items = itemRepository.findAll();

        return items.stream()
                .map(item -> new PostDto.Response(
                        item.getId(),
                        item.getTitle(),
                        item.getContent(),
                        item.getPrice(),
                        item.getUsername()
                ))
                .collect(Collectors.toList());
    }

    public PostDto.Response updatePost(Long id, PostDto.Request dto) {
        System.out.println(id);
        ItemEntity item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found"));

        item.setTitle(dto.getTitle());
        item.setContent(dto.getContent());
        item.setPrice(dto.getPrice());
        item.setUsername(dto.getUsername());

        return PostDto.Response.builder()
                .id(item.getId())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .username(item.getUsername())
                .build();
    }

    public MessageDto.Response deletePost(Long id) {
        ItemEntity item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found"));

        itemRepository.delete(item);

        return MessageDto.Response.builder()
                .msg("삭제완료")
                .build();
    }
}
