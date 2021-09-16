package Practice.CustomExceptionExample.Account.dto;

import Practice.CustomExceptionExample.Account.entity.Member;
import lombok.Getter;

@Getter
public class MemberDto {

    private Long id;
    private String memberId;
    private String memberName;
    private String memberEmail;


    public MemberDto(Member entity) {
        this.id = entity.getId();
        this.memberId = entity.getMemberId();
        this.memberName = entity.getMemberName();
        this.memberEmail = entity.getMemberEmail();
    }
}
