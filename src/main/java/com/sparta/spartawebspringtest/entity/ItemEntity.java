package com.sparta.spartawebspringtest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name ="item")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemEntity{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private int price;

    @Column
    private String username; // member

}
