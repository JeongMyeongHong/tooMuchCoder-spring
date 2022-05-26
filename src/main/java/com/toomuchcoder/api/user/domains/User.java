package com.toomuchcoder.api.user.domains;

import com.sun.istack.NotNull;
import com.toomuchcoder.api.board.domains.Article;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName   :   com.toomuchcoder.api.domains
 * fileName      :   User
 * author        :   JeongmyeongHong
 * date          :   2022-05-03
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-03      JeongmyoengHong     최초 생성
 * 2022-05-24      JeongmyoengHong     User 분리 / 검증되지 않은 User 분리.
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name="users")
public class User {
    @Id @Column(name = "user_id") @GeneratedValue private long userId;
    @Column private @NotNull String username;
    @Column private @NotNull String password;
    @Column private @NotNull String name;
    @Column private @NotNull String email;
    @Column(name = "reg_date") @NotNull private String regDate;

    @OneToMany(mappedBy = "user")
    List<Article> articles = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    public List<Role> roles;
}
