package com.web.board.entity.item;

import com.web.board.entity.Category;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_content")
    private String itemContent;

    @Column(name = "item_price")
    private int itemPrice;

    @Column(name = "item_stock_cnt")
    private int itemStockCnt;

    @Column(name = "item_sale_percentage")
    private int itemSalePercentage;

    @Column(name = "item_point_price")
    private int itemPointPrice;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<ItemImage> itemImages;


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
