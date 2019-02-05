package com.vhl.cli.picocli.options;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import com.vhl.cli.picocli.config.ConfigApp;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(description = "Process apps",
name = "Process app", mixinStandardHelpOptions = true, version = "Process App 1.0")
public class OptionsApp implements Callable<ConfigApp>{

	private static final Logger logger = LoggerFactory.getLogger(OptionsApp.class);
	
	private enum Lang { java, groovy, kotlin, javascript, frege, clojure }
	
	@Option(names = "-l", required = true,description = "@|fg(green) colors|@ Enum values: ${COMPLETION-CANDIDATES}")
    private Lang lang = null;
	
	@Option(names = "-f", required = true, description = "File configuration APP")
	private File config = null;

	@Override
	public ConfigApp call() throws Exception {
		logger.info("--------- OPTIONS SETTING -------------");
		
		if (!config.exists()) {
			logger.error("Files not exist : "+config.getName());
			System.exit(1);
		}
		
		ConfigApp confYaml = null;
		Yaml yaml = new Yaml();  
        try{
        	logger.info("LOAD CONFIG");
        	InputStream in = Files.newInputStream(Paths.get(config.getPath()));
        	confYaml = yaml.loadAs( in, ConfigApp.class );
            logger.info(confYaml.toString());
            confYaml.setLang(lang.name());
            return confYaml;
        } catch (Exception e) {
        	logger.error(e.getMessage());
		} 
        return null;
        
	}
	
}
