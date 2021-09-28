package Practice.CustomExceptionExample.Account.service;

import Practice.CustomExceptionExample.Account.dto.MemberDto;
import Practice.CustomExceptionExample.Account.dto.MemberJoinDto;
import Practice.CustomExceptionExample.Account.entity.Member;
import Practice.CustomExceptionExample.Account.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService{

    private final MemberRepository memberRepository;

    @Transactional
    public Long save(MemberJoinDto memberJoinDto){
        return memberRepository.save(memberJoinDto.toEntity()).getId();
    }
    @Transactional(readOnly = true)
    public List<MemberDto> findAll(){
        return memberRepository.findAll().stream().map(member -> new MemberDto(member)).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }

}
