package de.sebastian.CDITest.root;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import de.sebastian.CDITest.main.MainWindow;

@Theme("runo")
@PreserveOnRefresh
@SessionScoped
public class CDIUI extends UI implements Serializable {
	
	private MainWindow mainWindow;
    
	@Inject
	public CDIUI(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	
	public CDIUI() {
		
	}
	
//    @Override
//    protected void init(WrappedRequest request) {
//        setSizeFull();
//        getApplication().setRootPreserved(true);
//        controller.go();
//
//    }

    @Override
    public void init(VaadinRequest request) {
    	setSizeFull();
    	
    	mainWindow.go();
//    	 getContent().addComponent(
//                 new Label("This browser does not support touch events"));
    }
    
	@Override
	public void markAsDirty() {
		// TODO Auto-generated method stub
		
	}
	
}
