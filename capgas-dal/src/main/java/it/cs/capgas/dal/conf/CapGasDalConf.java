package it.cs.capgas.dal.conf;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "it.cs.capgas.dal.repository")
public class CapGasDalConf {
    // TODO: add embedded accl alse

    // public final static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    // public final static String address = "jdbc:derby:csgasDB";//;create=true"; //param

    // DERBY
    // TODO: get from placeholder
    // public final static String driver = "org.apache.derby.jdbc.ClientDriver";
    // public final static String address = "jdbc:derby://localhost:1527/capgasDB;user=capgas;password=capgas;ssl=basic;create=true";//param

    // MYSQL
    // TODO: get from placeholder
    // TODO: add SSL
    // public final static String driver = "org.mariadb.jdbc.Driver";
    // public final static String address = " jdbc:mysql://metropolis:3306/capgas";

    // Oracle XE
    // TODO: get from placeholder
    // TODO: add SSL
    public final static String driver = "oracle.jdbc.driver.OracleDriver";
    public final static String address = "jdbc:oracle:thin:@metropolis:1521:xe";

    private EntityManagerFactory emf;

    @Bean
    public DataSource dataSource() {
	// TODO: add embedded class also
	// return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.DERBY).build();

	// naive
	DriverManagerDataSource ds = new DriverManagerDataSource();
	ds.setDriverClassName(driver);
	ds.setUrl(address);

	// for MySQL
	ds.setUsername("capgas");
	ds.setPassword("capgas");

	return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
	final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	vendorAdapter.setGenerateDdl(true);
	vendorAdapter.setShowSql(true);

	final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	factory.setJpaVendorAdapter(vendorAdapter);
	factory.setPackagesToScan("it.cs.capgas.entity");
	factory.setDataSource(dataSource());
	factory.afterPropertiesSet();

	// set
	return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {
	return new JpaTransactionManager(entityManagerFactory().getObject());

	// final JpaTransactionManager transactionManager = new JpaTransactionManager();
	// transactionManager.setEntityManagerFactory(this.emf);
	// transactionManager.setDataSource(dataSource());
	//
	// // transactionManager.setJpaDialect(Oracle10gDialect);
	// // transactionManager.setJpaDialect(MySQL57InnoDBDialect);
	// // transactionManager.setJpaDialect(DerbyDialect);
	// return transactionManager;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
	return new HibernateExceptionTranslator();
    }
}
