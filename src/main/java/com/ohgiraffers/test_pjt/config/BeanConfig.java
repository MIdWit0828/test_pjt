package com.ohgiraffers.test_pjt.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
public class BeanConfig {
    @Bean
    public ModelMapper modelMapper() {
        /* setter 메소드 미사용 시 ModelMapper가
         * private 필드에 접근할 수 있도록 설정
         * */
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldAccessLevel(
                        org.modelmapper.config.Configuration.AccessLevel.PRIVATE
                )
                .setFieldMatchingEnabled(true);
        return modelMapper;
    }
}
