package com.toomuchcoder.api.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

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
 */
@Data
@Component // 컴포넌트는 property, method의 집합이다.
public class User {
    private String userid;
    private String password;
    private String email;
    private String name;
    private String phone;
    private String birth;
    private String address;
}
