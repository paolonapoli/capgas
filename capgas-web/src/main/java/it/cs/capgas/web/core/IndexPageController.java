package it.cs.capgas.web.core;

import org.springframework.stereotype.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

@VariableResolver(DelegatingVariableResolver.class)
@Component("indexPageController")
public class IndexPageController extends SelectorComposer<org.zkoss.zk.ui.Component>{
    
    /**
     * 
     */
    private static final long serialVersionUID = 304308296677454468L;

    @Listen("onClick=#btnLogout")
    public void doLogout() {
	Executions.sendRedirect("/logout");
    }
}
