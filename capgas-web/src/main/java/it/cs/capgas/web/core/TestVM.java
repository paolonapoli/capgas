package it.cs.capgas.web.core;

import org.springframework.stereotype.Component;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

@VariableResolver(DelegatingVariableResolver.class)
@Component("testVMprova")
public class TestVM {

	private String name = "pepe";

	@WireVariable
	TestService testService;
	
	@Command
	@NotifyChange("name")
	public void ook() {
		name = testService.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
