/**
 * 
 */
package it.cs.capgas.web.core;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;

/**
 * Class Manlod
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
public class SecureTomcatConnectionCustomizer implements TomcatConnectorCustomizer {

    private String absoluteKeystoreFile;
    private String keystorePassword;
    private String keystoreType;
    private String keystoreAlias;

    public SecureTomcatConnectionCustomizer(String absoluteKeystoreFile,
        String keystorePassword, String keystoreType, String keystoreAlias) {
      this.absoluteKeystoreFile = absoluteKeystoreFile;
      this.keystorePassword = keystorePassword;
      this.keystoreType = keystoreType;
      this.keystoreAlias = keystoreAlias.toLowerCase();

    }

    @Override
    public void customize(Connector connector) {
      connector.setPort(8443);
      connector.setSecure(true);
      connector.setScheme("https");
      
      connector.setAttribute("SSLEnabled", true);
          connector.setAttribute("sslProtocol", "TLS");
          connector.setAttribute("protocol", "org.apache.coyote.http11.Http11Protocol");
          connector.setAttribute("clientAuth", false);
          connector.setAttribute("keystoreFile", absoluteKeystoreFile);
          connector.setAttribute("keystoreType", keystoreType);
          connector.setAttribute("keystorePass", keystorePassword);
          connector.setAttribute("keystoreAlias", keystoreAlias);
          connector.setAttribute("keyPass", keystorePassword);
    }
  }