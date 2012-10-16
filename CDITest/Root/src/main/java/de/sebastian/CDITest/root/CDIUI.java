package de.sebastian.CDITest.root;

import javax.inject.Inject;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.Root;
import com.vaadin.cdi.VaadinUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.sebastian.CDITest.backend.TestBackend;
import de.sebastian.CDITest.main.MainWindow;

@Theme("runo")
//@PreserveOnRefresh
//@Root
@VaadinUI
public class CDIUI extends UI {
	
	private MainWindow mainWindow;
	private TestBackend backend;
    
	@Inject
	public CDIUI(MainWindow mainWindow, TestBackend backend) {
		this.mainWindow = mainWindow;
		this.backend = backend;
	}
	

    @Override
    public void init(VaadinRequest request) {
    	setSizeFull();
    	VerticalLayout vLayout = new VerticalLayout();
    	Label label = new Label("Das HauptUI");
    	vLayout.addComponent(label);
    	addComponent(vLayout);
    	backend.saveUser("sebastian");
    	
    	mainWindow.go();
    }
	
}
