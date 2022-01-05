package com.SalesManager.repository;

import java.util.ArrayList;
import java.util.List;

import com.SalesManager.Entity.NhanVienEntity;
import com.SalesManager.Service.NhanVienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class NhanVienDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private NhanVienService nhanVienService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NhanVienEntity nhanVien = nhanVienService.findBySoDienThoai(username);
        if(nhanVien == null){
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("nhanvien");
        grantList.add(authority);

        UserDetails userDetails = (UserDetails) new User(nhanVien.getSoDienThoai(), nhanVien.getPassword(), grantList);
		return userDetails;
    }

}
