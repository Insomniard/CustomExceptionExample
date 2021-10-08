package Practice.CustomExceptionExample.Account.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum roleLevel {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private final String level;
}
