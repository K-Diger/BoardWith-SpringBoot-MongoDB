package com.diger.notonlysqlboard.util.aop;

import com.diger.notonlysqlboard.core.user.domain.User;
import com.diger.notonlysqlboard.core.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Component
@RequiredArgsConstructor
public class UserAuthenticationAspect {

    private final HttpServletRequest httpServletRequest;
    private final UserRepository userRepository;

    @Around("@within(com.diger.notonlysqlboard.util.aop.UserAuthentication)")
    public Object userId(ProceedingJoinPoint pjp) throws Throwable {
        String userId = resolveToken(httpServletRequest);
        User user = userRepository.findById(userId).orElseThrow();

        UserAuthenticationContext.USER_CONTEXT.set(user);
        return pjp.proceed(pjp.getArgs());
    }

    private String resolveToken(HttpServletRequest httpServletRequest) {
        String bearerToken = httpServletRequest.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
