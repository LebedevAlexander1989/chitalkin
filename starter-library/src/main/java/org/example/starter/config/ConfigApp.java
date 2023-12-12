package org.example.starter.config;

import org.example.core.domain.StatusBook;
import org.example.core.domain.Book;
import org.example.persistence.entity.BookEntity;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@Configuration
@EnableMapRepositories(basePackages = "org.example.persistence")
@ComponentScan(basePackages = {"org.example.api", "org.example.core", "org.example.persistence"})
public class ConfigApp {

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        final Converter<String, StatusBook> converter = ctx -> ctx.getSource() == null ? null : StatusBook.valueOf(ctx.getSource());
        modelMapper.typeMap(BookEntity.class, Book.class)
                .addMappings(mapper -> mapper.using(converter)
                        .map(BookEntity::getStatus, Book::setStatusBook));
        return modelMapper;
    }
}
