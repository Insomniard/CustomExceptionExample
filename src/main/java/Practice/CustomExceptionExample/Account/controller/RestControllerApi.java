package Practice.CustomExceptionExample.Account.controller;

import Practice.CustomExceptionExample.Account.dto.MemberDto;
import Practice.CustomExceptionExample.Account.dto.MemberJoinDto;
import Practice.CustomExceptionExample.Account.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class RestControllerApi {

    private final MemberService memberService;

    @GetMapping("")
    public Long save(@RequestBody MemberJoinDto memberJoinDto){
        return memberService.save(memberJoinDto);

    }

    @GetMapping("/list")
    public List<MemberDto> findAll(){
        return memberService.findAll();
    }

    @GetMapping("/agree")
    public Object agreeTestApi()throws Exception{
        return memberService.agreetest();
    }

    @GetMapping("/")
    public Object denyTestApi()throws Exception{
        return memberService.denytest();
    }

}
