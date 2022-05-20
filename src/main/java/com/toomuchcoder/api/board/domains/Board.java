package com.toomuchcoder.api.board.domains;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName   :   com.toomuchcoder.api.domains
 * fileName      :   Board
 * author        :   JeongmyeongHong
 * date          :   2022-05-04
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-04      JeongmyoengHong     최초 생성
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "boards")
public class Board {
    @Id @Column(name = "board_id") @GeneratedValue private long boardId;
    @Column @NotNull
    private String boardName;
    @Column(name = "created_date") @NotNull private String createDate;

    @OneToMany(mappedBy = "board")
    List<Article> articles = new ArrayList<>(); // board가 들어갈 공간을 만들어둬야 들어갈 수 있다.

    @OneToMany(mappedBy = "boardComment")
    List<Comment> comments = new ArrayList<>();
}
