package Practice.CustomExceptionExample.Account.controller;

import Practice.CustomExceptionExample.Account.entity.Member;
import Practice.CustomExceptionExample.Account.repository.MemberRepository;
import Practice.CustomExceptionExample.Account.service.MemberService;
import Practice.CustomExceptionExample.Account.util.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class RestControllerApi {

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;
    private final TokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;

    @PostMapping("/join")
    public Long join(@RequestBody Map<String, String> member) {
        return memberRepository.save(Member.builder()
                .email(member.get("email"))
                .password(passwordEncoder.encode(member.get("password")))
                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                .build()).getId();
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        Member member = memberRepository.findByEmail(user.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.generateToken(member.getUsername(), member.getRoles());
    }

}
