package com.toomuchcoder.api.user.controllers;

import com.toomuchcoder.api.auth.domains.Messenger;
import com.toomuchcoder.api.user.domains.User;
import com.toomuchcoder.api.user.domains.UserDTO;
import com.toomuchcoder.api.user.services.UserService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName   :   com.toomuchcoder.api.controllers
 * fileName      :   UserController
 * author        :   JeongmyeongHong
 * date          :   2022-05-03
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-03      JeongmyoengHong     최초 생성
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "user")
@RestController // 컨트롤러 컴포넌트 빈 객체 생성.
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {

    private final UserService service;
    private final ModelMapper modelMapper;

    // @ApiResponse(code=400, message= "Something Wrong"),
    // @ApiResponse(code=422, message= "유효하지 않은 아이디 / 비밀번호")
    @PostMapping("/login")
    @ApiOperation(value = "${UserController.login}")
    @ApiResponses(value={
            @ApiResponse(code=400, message= "Something Wrong"),
            @ApiResponse(code=422, message= "유효하지 않은 아이디 / 비밀번호")
    })
    public ResponseEntity<UserDTO> login(@ApiParam("Login User") @RequestBody UserDTO user){
        return ResponseEntity.ok(service.login(user));
    }
    @GetMapping("/logout")
    public ResponseEntity<Messenger> logout(){
        return null;
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/findAll/sort")
    public ResponseEntity<List<User>> findAll(Sort sort) {
        return ResponseEntity.ok(service.findAll(sort));
    }
    @GetMapping("/findAll/pageable")
    public ResponseEntity<Page<User>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }
    @GetMapping("/count")
    public ResponseEntity<Messenger> count() {
        return ResponseEntity.ok(service.count());
    }
    @PutMapping("/put")
    public ResponseEntity<Messenger> update(@RequestBody User user) {
        return ResponseEntity.ok(service.update(user));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> delete(@RequestBody User user) {
        return ResponseEntity.ok(service.delete(user));
    }

    @PostMapping("/join")
    @ApiOperation(value = "${UserController.join}")
    @ApiResponses(value={
            @ApiResponse(code=400, message= "Something Wrong"),
            @ApiResponse(code=403, message= "승인 거절"),
            @ApiResponse(code=422, message= "중복된 ID")
    })
    public ResponseEntity<Messenger> save(@ApiParam("Join User") @RequestBody UserDTO user) {
        System.out.println("회원가입 정보 : " + user.toString());
        return ResponseEntity.ok(service.save(user));
    }
    @GetMapping("/findById/{userid}")
    public ResponseEntity<Optional<User>> findById(@PathVariable String userid) {
        return ResponseEntity.ok(service.findById(userid));
    }
    @GetMapping("/existsById/{userid}")
    public ResponseEntity<Messenger> existsById(@PathVariable String userid) {
        return ResponseEntity.ok(service.existsById(userid));
    }
//    @GetMapping("/findOne")
//    public <S extends User> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//    @GetMapping("/exists")
//    public <S extends User> boolean exists(Example<S> example) {
//        return false;
//    }

}
