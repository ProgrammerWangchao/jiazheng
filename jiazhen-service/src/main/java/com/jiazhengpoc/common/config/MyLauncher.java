package com.jiazhengpoc.common.config;

import java.io.File;
import java.io.IOException;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@ComponentScan("com.jiazhengpoc")
@MapperScan("com.jiazhengpoc")
public class MyLauncher {

//	@Autowired
//	private Environment env;

	/**
	 * 入口程序
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MyLauncher.class, args);
	}

	/**
	 * 配置一个TomcatEmbeddedServletContainerFactory bean spring 2.0之前
	 * ServletWebServerFactory bean spring 2.0之后
	 * 
	 * @return
	 */
	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		// tomcat.addAdditionalTomcatConnectors(createSslConnector());
//		System.out.println("key-store:" + env.getProperty("key-store"));
		tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
		return tomcat;
	}

	/**
	 * sSl安全证书 httpS访问需要
	 * 
	 * @return
	 */
	private Connector createSslConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
		try {
			File keystore = new ClassPathResource("jiazheng.jks").getFile();
			File truststore = new ClassPathResource("jiazheng.jks").getFile();
			connector.setScheme("https");
			connector.setSecure(true);
			connector.setPort(7443);
			protocol.setSSLEnabled(true);
			protocol.setKeystoreFile(keystore.getAbsolutePath());
			protocol.setKeystorePass("whl314228");
			protocol.setTruststoreFile(truststore.getAbsolutePath());
			protocol.setTruststorePass("changeit");
			protocol.setKeyAlias("whl314228");
			return connector;
		} catch (IOException ex) {
			throw new IllegalStateException(
					"can't access keystore: [" + "keystore" + "] or truststore: [" + "keystore" + "]", ex);
		}
	}

	/**
	 * 让我们的应用支持HTTP是个好想法，但是需要重定向到HTTPS，
	 * 但是不能同时在application.properties中同时配置两个connector， 所以要以编程的方式配置HTTP
	 * connector，然后重定向到HTTPS connector
	 * 
	 * @return Connector
	 */
	private Connector initiateHttpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8080); // http端口
		connector.setSecure(false);
		connector.setRedirectPort(7443); // application.properties中配置的https端口
		return connector;
	}

}
