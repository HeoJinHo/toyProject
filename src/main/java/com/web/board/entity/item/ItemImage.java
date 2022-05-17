package com.web.board.entity.item;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ItemImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;

    private String imageUrl;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;


    @Column(name="reg_date")
    @CreationTimestamp
    private LocalDateTime regDate;

    @Column(name="reg_member_no", precision=10)
    private Long regMemberNo;


    @Column(name="mod_member_date")
    @UpdateTimestamp
    private LocalDateTime modMemberDate;


    @Column(name="mod_member_no", precision=10)
    private Long modMemberNo;



}
