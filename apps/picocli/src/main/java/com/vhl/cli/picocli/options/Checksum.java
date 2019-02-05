package com.vhl.cli.picocli.options;

import java.io.File;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(description = "Prints the checksum (MD5 by default) of a file to STDOUT.",
name = "checksum", mixinStandardHelpOptions = true, version = "checksum 3.0")
public class Checksum implements Callable<Void> {

	private static final Logger logger = LoggerFactory.getLogger(Checksum.class);
	
    @Parameters(index = "0", description = "The file whose checksum to calculate.")
    private File file;

    @Option(names = {"-a", "--algorithm"}, description = "MD5, SHA-1, SHA-256, ...")
    private String algorithm = "MD5";
	

    
    @Override
    public Void call() throws Exception {
        // your business logic goes here...
        byte[] fileContents = Files.readAllBytes(file.toPath());
        byte[] digest = MessageDigest.getInstance(algorithm).digest(fileContents);
        logger.info(javax.xml.bind.DatatypeConverter.printHexBinary(digest));
        return null;
    }
	
    public Checksum() {
	}
    
	
	
	
}
