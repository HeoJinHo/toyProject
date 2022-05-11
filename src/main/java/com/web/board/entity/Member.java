package com.web.board.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member{

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    // Entity 는 아니지만 내장 타입으로 컬럼으로 사용가능
    @Embedded
    private Address address;


    // Order Table 의 변수명 member 로 bappedBy
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();



}
