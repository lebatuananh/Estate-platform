package com.mra.service.impl;

import com.mra.converter.UserConverter;
import com.mra.dto.MyUserDetail;
import com.mra.dto.UserDTO;
import com.mra.entity.RoleEntity;
import com.mra.entity.UserEntity;
import com.mra.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUserName(username);
        UserDTO userDTO = userConverter.convertToDto(userEntity);
        //check xem user co ton tai khong
        if (userDTO == null) {
            throw new UsernameNotFoundException("username not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity role : userEntity.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
        MyUserDetail myUserDetail = new MyUserDetail(username, userEntity.getPassword(), true, true, true, true, authorities);
        BeanUtils.copyProperties(userDTO, myUserDetail);
        return myUserDetail;
    }
}
