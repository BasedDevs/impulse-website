package com.baseddevs.userservice.mapper;

import com.baseddevs.userservice.dto.auth.PasswordResetTokenDTO;
import com.baseddevs.userservice.dto.permission.PermissionDTO;
import com.baseddevs.userservice.dto.user.UserDTO;
import com.baseddevs.userservice.model.PasswordResetToken;
import com.baseddevs.userservice.model.Permission;
import com.baseddevs.userservice.model.User;
import com.baseddevs.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PasswordResetTokenMapper {

    private final UserService userService;
    private final UserMapper userMapper;

    public PasswordResetTokenDTO toDTO(PasswordResetToken token) {
        return new PasswordResetTokenDTO(token.getToken(), token.getExpiryDate(), token.getUser().getUsername());
    }

    public PasswordResetToken toEntity(PasswordResetTokenDTO tokenDTO) {
        PasswordResetToken token = new PasswordResetToken();
        token.setToken(tokenDTO.token());
        token.setExpiryDate(tokenDTO.expiryDate());
        UserDTO userDTO = userService.findByUsername(tokenDTO.username());
        //User user = userMapper.toEntity(userDTO);
        //token.setUser(user);
        return token;
    }

}
