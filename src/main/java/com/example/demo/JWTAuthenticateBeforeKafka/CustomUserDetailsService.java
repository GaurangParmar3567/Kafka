package com.example.demo.JWTAuthenticateBeforeKafka;

import java.util.Collections;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // In real apps, load from DB

        if ("user".equals(username)) {
            return new User("user", "{noop}root@1234567", Collections.emptyList());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}

// @Component
// public class fetchUserClass {

// public JdbcTemplate jdbcTemplate;

// @Autowired
// public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
// this.jdbcTemplate = jdbcTemplate;
// }

// fetchUserClass() {
// DataSource dataSource = DataSourceConfig.getDataSource();

// jdbcTemplate.setDataSource();
// }

// public String fetchPasswordAndUsername(String username) {

// String sql = "SELECT password FROM users WHERE username = ?";
// return jdbcTemplate.queryForObject(sql, new Object[]{username},
// String.class);
// }
// }
