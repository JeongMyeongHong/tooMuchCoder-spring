package com.toomuchcoder.api.auth.domains;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName   :   com.toomuchcoder.api.auth.domains
 * fileName      :   Board
 * author        :   JeongmyeongHong
 * date          :   2022-05-18
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-18      JeongmyoengHong     최초 생성
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
    @Column @NotNull private String boardName;
    @Column(name = "created_date") @NotNull private String createDate;

    @OneToMany(mappedBy = "board")
    List<Article> articles = new ArrayList<>();
}
