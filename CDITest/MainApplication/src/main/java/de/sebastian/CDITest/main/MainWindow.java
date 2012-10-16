package de.sebastian.CDITest.main;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.cdi.VaadinView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.sebastian.CDITest.backend.TestBackend;
import de.sebastian.CDITest.second.SecondWindow;

@VaadinView
public class MainWindow extends CustomComponent implements Serializable {
	
	private SecondWindow secWin;
	private TestBackend backend;

	private VerticalLayout vLayout;
	
	@Inject
	public MainWindow(SecondWindow secWin, TestBackend backend) {
		this.secWin = secWin;
		this.backend = backend;
	}
	
	@PostConstruct
	public void initialize() {
		vLayout = new VerticalLayout();
		setCompositionRoot(vLayout);
		setSizeFull();
		setCaption("First Window");
		
		layout();
	}
	
	public void go(){
		UI.getCurrent().removeAllComponents();
		UI.getCurrent().addComponent(this);
		
	}

	private void layout() {
		String lblText = backend.getUser();
		Label lbl = new Label(lblText);
		vLayout.addComponent(lbl);
		
		Button btn1 = new Button("First Button", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				openNewWindow();
			}
		});
		vLayout.addComponent(btn1);
		
	}
	
	public void openNewWindow() {
		
		UI.getCurrent().addWindow(secWin);
	}

}
