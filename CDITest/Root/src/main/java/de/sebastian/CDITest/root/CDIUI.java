package de.sebastian.CDITest.root;

import javax.inject.Inject;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.VaadinUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import de.sebastian.CDITest.backend.TestBackend;
import de.sebastian.CDITest.main.presenter.MainWindowPresenter;

@Theme("runo")
//@PreserveOnRefresh
//@Root
@VaadinUI
public class CDIUI extends UI {
	
	private MainWindowPresenter mainPresenter;
	private TestBackend backend;
    
	@Inject
	public CDIUI(MainWindowPresenter mainPresenter, TestBackend backend) {
		this.mainPresenter = mainPresenter;
		this.backend = backend;
	}
	

    @Override
    public void init(VaadinRequest request) {
    	setSizeFull();
    	backend.saveUser("sebastian");
    	
    	mainPresenter.initialize();
    }
	
}
