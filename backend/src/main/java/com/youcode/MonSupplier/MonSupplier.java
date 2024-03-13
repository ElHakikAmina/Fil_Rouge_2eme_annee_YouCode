package com.youcode.MonSupplier;

import com.youcode.MonSupplier.models.Entities.Admin;
import com.youcode.MonSupplier.models.Enums.RoleUser;
import com.youcode.MonSupplier.repositories.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonSupplier {
    public static void main(String[] args) {
        SpringApplication.run(MonSupplier.class, args);
    }
    @Bean
    CommandLineRunner start(AdminRepository adminRepository){
        return args -> {
            Admin admin = new Admin();
            admin.setId(1L);
            admin.setEmail("amina.el.hakik2@gmail.com");
            admin.setPassword("1234");
            admin.setRoleUser(RoleUser.Admin);
            adminRepository.save(admin);
        };
    }
}