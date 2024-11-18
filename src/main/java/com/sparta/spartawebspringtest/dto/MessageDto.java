package com.sparta.spartawebspringtest.dto;

import lombok.*;


public class MessageDto {

    @Builder
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        String msg;
    }
}
