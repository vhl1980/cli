package com.vhl.cli.picocli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vhl.cli.picocli.options.Checksum;

import picocli.CommandLine;

public class MainTest {

	private static final Logger logger = LoggerFactory.getLogger(MainTest.class);
	
	public static void main(String[] args) {
		
		
		//String[] t_args = { "-h" };
		//String[] t_args = { "data/test", "-a", "SHA-256"};
		String[] t_args = { "data/test", "-a=SHA-256"};
		CommandLine.call(new Checksum(), t_args);
		logger.info("-----------------");
		logger.info("END");
		
	}

}
