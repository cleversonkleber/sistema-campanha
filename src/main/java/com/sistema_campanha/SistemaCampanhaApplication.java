package com.sistema_campanha;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class SistemaCampanhaApplication {

	private static Logger log = LoggerFactory.getLogger(SistemaCampanhaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SistemaCampanhaApplication.class, args);
		log.info("mensagem inicicial");
		log.error("messagem error");
		log.warn("msg warn");
		log.debug("msg debug");
	}



}
