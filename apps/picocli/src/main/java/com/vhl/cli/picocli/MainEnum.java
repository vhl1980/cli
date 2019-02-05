package com.vhl.cli.picocli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vhl.cli.picocli.config.ConfigApp;
import com.vhl.cli.picocli.options.OptionsApp;

import picocli.CommandLine;

public class MainEnum {

	private static final Logger logger = LoggerFactory.getLogger(MainEnum.class);
	
	public static void main(String[] args) {
		//String[] t_args = { "-h"};
		//String[] t_args = { "-f","config/app.yaml","-l","java"};
		ConfigApp confYaml = CommandLine.call(new OptionsApp(), args);
		
		logger.info("********** LET IT GO  ************");
		logger.info("Langue : "+confYaml.getLang());
		logger.info("**********************");
		logger.info("END");

	}

}
