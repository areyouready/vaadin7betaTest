package de.sebastian.CDITest.main;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import de.sebastian.CDITest.second.SecondWindow;


public class MainWindow extends Window implements Serializable {
	
	private UI ui;
	private SecondWindow secWin;
	
	@Inject
	public MainWindow(UI ui, SecondWindow secWin) {
		this.ui = ui;
		this.secWin = secWin;
	}
	
	@PostConstruct
	public void initialize() {
		setSizeFull();
		setCaption("First Window");
		
		layout();
	}
	
	public void go(){
		ui.addWindow(this);
	}

	private void layout() {
		VerticalLayout vLayout = new VerticalLayout();
		
		Button btn1 = new Button("First Button", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				openNewWindow();
			}
		});
		
		vLayout.addComponent(btn1);
		setContent(vLayout);
		
	}
	
	public void openNewWindow() {
		
		ui.addWindow(secWin);
	}

}
