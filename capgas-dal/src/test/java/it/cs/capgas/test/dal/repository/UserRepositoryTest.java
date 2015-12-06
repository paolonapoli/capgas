/**
 *
 */
package it.cs.capgas.test.dal.repository;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import it.cs.capgas.dal.conf.CapGasDalConf;
import it.cs.capgas.dal.repository.GroupRepository;
import it.cs.capgas.dal.repository.UserRepository;
import it.cs.capgas.entity.Group;
import it.cs.capgas.entity.User;

/**
 * Class Test
 *
 * @author Paolo Napoli <paolonapoli.dev(at)gmail(dot)com>
 *
 */
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CapGasDalConf.class })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    // @Autowired
    // private CategoryRepository categoryRepository;

    @Autowired
    private EntityManager em;

    // @Before
    public void init() {
	this.groupRepository.deleteAll();
	this.em.flush();
	this.userRepository.deleteAll();
	this.em.flush();
    }

    @Test
    public void test2() {
	// User paolo = this.userRepository.findOne("paolo");
	// System.out.println("USERNAME: " + paolo);
	// Set<Group> authorities = paolo.getAuthorities();
	// for (Group authority : authorities) {
	// System.out.println("Username AUTHORITY: " + authority);
	// }
	//
	// System.out.println("\n\n***************\n\n");
	//
	// User cons = this.userRepository.findOne("cons");
	// System.out.println("USERNAME: " + cons);
	// authorities = cons.getAuthorities();
	// for (Group authority : authorities) {
	// System.out.println("Username AUTHORITY: " + authority);
	// }
    }

    @Test
    public void testSaveOtm() {
	// // user
	// User gigi = new User();
	// gigi.setUsername("gigi");
	// gigi.setPassword("gigi123");
	// gigi.setEmail("gigi@gas.it");
	//
	// // authorities
	// Set<Group> aut = new HashSet<>();
	// aut.add(new Group(new AuthorityKey(gigi, "ROLE_USER")));
	// aut.add(new Group(new AuthorityKey(gigi, "ROLE_CONS")));
	//
	// // save
	// this.userRepository.save(gigi);
	//
	// User cons = this.userRepository.findOne("gigi");
	// System.out.println("USERNAME: " + cons);
	// Set<Group> authorities = cons.getAuthorities();
	// if (authorities != null) {
	// for (Group authority : authorities) {
	// System.out.println("Username AUTHORITY: " + authority);
	// }
	// }
    }

    @Test
    public void pupulateUsers() {
	init();

	System.out.println("************ Adding Users ********************");
	//@formatter:off
	String[] users = new String[]{"user", "admin", "cons", "prod"};
	String[] passwords = new String[]{"user", "admin", "cons", "prod"};
	String[] emails = new String[]{"user@gas.it", "admin@gas.it", "cons@gas.it", "prod@gas.it"};
	String[] phones = new String[]{"123456", "124567", "125678", "126789"};
	String[][] groups = new String[][]{
	    	{"USER"}
	    	, {"USER", "CONS", "PROD", "ADMIN"}
	    	, {"USER", "CONS"}
	    	, {"USER", "PROD"}
	};

	for (int i = 0; i < users.length; i++) {
	    User u = new User();
	    u.setUsername(users[i]);
	    u.setPassword(passwords[i]);
	    u.setEmail(emails[i]);
	    u.setTelephone(phones[i]);
	    this.userRepository.save(u);

	    for(String group: groups[i]){
		Group g = new Group();
		g.setName(StringUtils.capitalize(group));
		g.setAlias(StringUtils.upperCase(group));
		g.setUsername(u);
		this.groupRepository.save(g);
	    }//for groups
	}
	//@formatter:on
    }
}
