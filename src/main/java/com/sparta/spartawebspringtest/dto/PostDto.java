package com.sparta.spartawebspringtest.dto;

import jakarta.persistence.Column;
import lombok.*;


public class PostDto {
    @Builder
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private String title;
        private String content;
        private int price;
        private String username; // member
    }

    @Builder
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String title;
        private String content;
        private int price;
        private String username; // member
    }
}
