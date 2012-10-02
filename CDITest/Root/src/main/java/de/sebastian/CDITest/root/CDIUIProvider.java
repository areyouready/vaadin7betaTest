package de.sebastian.CDITest.root;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import com.vaadin.server.DefaultUIProvider;
import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.ui.UI;

@SessionScoped
public class CDIUIProvider extends DefaultUIProvider implements Serializable {

	@Inject
	private Instance<CDIUI> cdiUI;
	
	@Override
	public UI createInstance(UICreateEvent uiCreateEvent) {
		return cdiUI.get();
	}
	
	@Override
	public Class<? extends UI> getUIClass(UIClassSelectionEvent selectionEvent) {
		return CDIUI.class;
	}

}
