package com.nikitoe.board.config.auth;

import com.nikitoe.board.model.User;
import com.nikitoe.board.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrincipalDetailService implements UserDetailsService {

    // 해당 username이 DB에 있는 지 확인
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다 : " + username));
        return new PrincipalDetail(principal);// 시큐리티 세션에 저장
    }
}
