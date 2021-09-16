package Practice.CustomExceptionExample.Account.dto;

import Practice.CustomExceptionExample.Account.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberJoinDto {

    private String memberId;
    private String memberName;
    private String memberEmail;

    @Builder
    public MemberJoinDto(String memberId, String memberName, String memberEmail) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
    }

    public Member toEntity(){
        return Member.builder()
                .memberId(memberId)
                .memberName(memberName)
                .memberEmail(memberEmail)
                .build();
    }
}
