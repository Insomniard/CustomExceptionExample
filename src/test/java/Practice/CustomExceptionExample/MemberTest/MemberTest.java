//package Practice.CustomExceptionExample.MemberTest;
//
//import Practice.CustomExceptionExample.Account.dto.MemberDto;
//import Practice.CustomExceptionExample.Account.entity.Member;
//import Practice.CustomExceptionExample.Account.repository.MemberRepository;
//import Practice.CustomExceptionExample.Account.service.MemberService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//@SpringBootTest
//public class MemberTest {
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Autowired
//    private MemberService memberService;
//
//    @Test
//    public void 회원등록테스트(){
//        IntStream.rangeClosed(0,100).forEach(i -> {
//            Member member = Member.builder().
//                    memberIds("dummy id" + i).
//                    memberEmail("dummy email"+ i).
//                    memberName("dummy name"+ i).build();
//            memberRepository.save(member);
//        });
//    }
//
//
//}
