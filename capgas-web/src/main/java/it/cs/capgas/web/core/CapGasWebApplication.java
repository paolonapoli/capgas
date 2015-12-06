/**
 *
 */
package it.cs.capgas.web.core;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.util.ResourceUtils;
import org.zkoss.zk.au.http.DHtmlUpdateServlet;
import org.zkoss.zk.ui.http.DHtmlLayoutServlet;

import it.cs.capgas.dal.conf.CapGasDalConf;

/**
 * Class ManlodWebApplication
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import(CapGasDalConf.class)
public class CapGasWebApplication extends AbstractSecurityWebApplicationInitializer {
    public CapGasWebApplication() {
	super(SecurityConfig.class);
    }

    @Bean
    public ServletRegistrationBean dHtmlLayoutServlet() {
	Map<String, String> params = new HashMap<String, String>();
	params.put("update-uri", "/zkau");
	DHtmlLayoutServlet dHtmlLayoutServlet = new DHtmlLayoutServlet();
	ServletRegistrationBean reg = new ServletRegistrationBean(dHtmlLayoutServlet, "*.zul");
	reg.setLoadOnStartup(1);
	reg.setInitParameters(params);
	return reg;
    }

    @Bean
    public ServletRegistrationBean dHtmlUpdateServlet() {
	Map<String, String> params = new HashMap<String, String>();
	params.put("update-uri", "/zkau/*");
	ServletRegistrationBean reg = new ServletRegistrationBean(new DHtmlUpdateServlet(), "/zkau/*");
	reg.setLoadOnStartup(2);
	reg.setInitParameters(params);
	return reg;
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerSecureCustomizer() throws FileNotFoundException {
	final String absoluteKeystoreFile = ResourceUtils.getFile("keystore/manlod-ks.p12").getAbsolutePath();

	final TomcatConnectorCustomizer customizer = new SecureTomcatConnectionCustomizer(absoluteKeystoreFile, "manlod",
		"PKCS12", "manlodKS");

	return new EmbeddedServletContainerCustomizer() {

	    @Override
	    public void customize(ConfigurableEmbeddedServletContainer container) {
		if (container instanceof TomcatEmbeddedServletContainerFactory) {
		    TomcatEmbeddedServletContainerFactory containerFactory = (TomcatEmbeddedServletContainerFactory) container;

		    // new connector
		    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		    customizer.customize(connector);

		    // add HTTPS connector
		    containerFactory.addAdditionalTomcatConnectors(connector);
		}
	    };
	};
    }

    static @Bean public PropertySourcesPlaceholderConfigurer myPropertySourcesPlaceholderConfigurer() {
	PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
	Resource[] resourceLocations = new Resource[] { new ClassPathResource("app.properties")
		// , new ClassPathResource("my.other.properties")
	};
	p.setLocations(resourceLocations);
	return p;
    }

    public static void main(String[] args) {
	SpringApplication.run(CapGasWebApplication.class, args);
    }
}
