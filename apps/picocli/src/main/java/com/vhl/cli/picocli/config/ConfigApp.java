package com.vhl.cli.picocli.config;

import static java.lang.String.format;
import java.util.List;
import java.util.Map;

public class ConfigApp {

	private String version;
	private Connection connection;
    private List< String > protocols;
    private Map< String, String > kafka;
    private String Lang;
	
    public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public List< String > getProtocols() {
		return protocols;
	}
	public void setProtocols(List< String > protocols) {
		this.protocols = protocols;
	}

	public Map< String, String > getKafka() {
		return kafka;
	}
	public void setKafka(Map< String, String > kafka) {
		this.kafka = kafka;
	}
    @Override
    public String toString() {
        return new StringBuilder()
            .append( format( "Version: %s\n", version ) )
            .append( format( "Connecting to database: %s\n", connection ) )
            .append( format( "Supported protocols: %s\n", protocols ) )
            .append( format( "Users: %s\n", kafka ) )
            .toString();
    }
	public String getLang() {
		return Lang;
	}
	public void setLang(String lang) {
		Lang = lang;
	}

    
}
