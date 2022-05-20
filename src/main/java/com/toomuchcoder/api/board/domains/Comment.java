package com.toomuchcoder.api.board.domains;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * packageName   :   com.toomuchcoder.api.board.domains
 * fileName      :   Comment
 * author        :   JeongmyeongHong
 * date          :   2022-05-09
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-09      JeongmyoengHong     최초 생성
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "comments")
public class Comment {
    @Id @Column(name = "comment_id") @GeneratedValue private long commentId;
    @Column @NotNull
    private String commentName;
    @Column(name = "created_date") @NotNull private String createDate;

    @ManyToOne
    @JoinColumn(name = "board_id")
    Board boardComment;
}
