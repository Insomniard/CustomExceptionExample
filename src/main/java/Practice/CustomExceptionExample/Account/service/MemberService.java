package Practice.CustomExceptionExample.Account.service;

import Practice.CustomExceptionExample.Account.dto.MemberDto;
import Practice.CustomExceptionExample.Account.dto.MemberJoinDto;
import Practice.CustomExceptionExample.Account.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long save(MemberJoinDto memberJoinDto){
        return memberRepository.save(memberJoinDto.toEntity()).getId();
    }
    @Transactional(readOnly = true)
    public List<MemberDto> findAll(){
        return memberRepository.findAll().stream().map(member -> new MemberDto(member)).collect(Collectors.toList());

    }
}
