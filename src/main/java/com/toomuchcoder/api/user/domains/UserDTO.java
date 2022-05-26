package com.toomuchcoder.api.user.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * packageName   :   com.toomuchcoder.api.auth.domains
 * fileName      :   UserDto
 * author        :   JeongmyeongHong
 * date          :   2022-05-24
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-24      JeongmyoengHong     최초 생성
 */
@Component
@Data
@ToString
public class UserDTO {
    @ApiModelProperty(position = 1) private long userId;
    @ApiModelProperty(position = 2) private String username;
    @ApiModelProperty(position = 3) private String password;
    @ApiModelProperty(position = 4) private String name;
    @ApiModelProperty(position = 5) private String email;
    @ApiModelProperty(position = 6) private String regDate;
    @ApiModelProperty(position = 7) private String token;
    @ApiModelProperty(position = 8) private List<Role> roles;
}
