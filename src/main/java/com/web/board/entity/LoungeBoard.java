package com.web.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "lounge_board")
public class LoungeBoard {
    @Column(name = "BOARD_NO")
    @Id @GeneratedValue
    private Long boardNo;

    @Column(name = "USER_NO")
    private Long userNo;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "NICKNAME")
    private String nickName;

    @Column(name = "CAT_NO")
    private Long catNo;

    @Column(name = "SUB_NO")
    private Long subNo;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "READ_CNT")
    private Long readCnt;

    @Column(name = "BADGE_YN")
    private Boolean badgeYn;

    @Column(name = "TOP_YN")
    private Boolean topYn;

    @Column(name = "TOP_DATE")
    private LocalDateTime topDate;

    @Column(name = "BEST_YN")
    private Boolean bestYn;

    @Column(name = "BEST_DATE")
    private LocalDateTime bestDate;

    @Column(name = "NOTICE_YN")
    private Boolean noticeYn;

    @Column(name = "REPLY_YN")
    private Boolean replyYn;

    @Column(name = "DISPLAY_END_DATE")
    private LocalDateTime displayEndDate;

    @Column(name = "DEL_YN")
    private Boolean delYn;

    @Column(name = "DEL_DATE")
    private LocalDateTime delDate;

    @Column(name = "ADMIN_DEL_YN")
    private Boolean adminDelYn;

    @Column(name = "ADMIN_DEL_DATE")
    private LocalDateTime adminDelDate;

    @Column(name = "DEL_ADMIN_NO")
    private Long delAdminNo;

    @Column(name = "REPORT_YN")
    private Boolean reportYn;

    @Column(name = "REPORT_DATE")
    private LocalDateTime reportDate;

    @UpdateTimestamp
    @Column(name = "MOD_DATE")
    private LocalDateTime modDate;

    @UpdateTimestamp
    @Column(name = "REG_DATE")
    private LocalDateTime regDate;

    @Column(name = "MOD_ADMIN_NO")
    private Long modAdminNo;

    @Column(name = "REG_ADMIN_NO")
    private Long regAdminNo;

    private LoungeBoard() {

    }

}
