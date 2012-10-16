package de.sebastian.CDITest.main.Window;

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

import de.sebastian.CDITest.main.presenter.MainWindowPresenter;

@VaadinView
public class MainWindow extends CustomComponent implements Serializable {

	private MainWindowPresenter presenter;

	private VerticalLayout vLayout;

	@Inject
	public MainWindow(MainWindowPresenter presenter) {
		this.presenter = presenter;
	}

	@PostConstruct
	public void initialize() {
		vLayout = new VerticalLayout();
		setCompositionRoot(vLayout);
		setSizeFull();
		setCaption("First Window");

		layout();
	}

	public void go() {
		UI.getCurrent().removeAllComponents();
		UI.getCurrent().addComponent(this);
	}

	private void layout() {
		String lblText = presenter.getUser();
		Label lbl = new Label(lblText);
		vLayout.addComponent(lbl);

		Button btn1 = new Button("First Button", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				presenter.openNewWindow();
			}
		});
		vLayout.addComponent(btn1);

	}

}
