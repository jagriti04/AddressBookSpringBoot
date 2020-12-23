package com.bridgelabz.greetingapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressBookBeans {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
