package de.sebastian.CDITest.second;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class SecondWindow extends Window implements Serializable{
	

	public SecondWindow() {
	}
	
	@PostConstruct
	public void initialize() {
		layout();
		
	}

	public void layout() {
		setHeight("400px");
		setWidth("500px");
		
		VerticalLayout vLayout = new VerticalLayout();
		
		Label label = new Label("Insert Text here");
		
		 Button button = new Button("Click Me");
	        button.addClickListener(new Button.ClickListener() {
	        	public void buttonClick(ClickEvent event) {
					closeWindow();
				}
	        });
	        addComponent(button);
		
		vLayout.addComponent(label);
		vLayout.addComponent(button);
		setContent(vLayout);
		
	}

	private void closeWindow() {
		UI.getCurrent().removeWindow(this);
		
	}

}
