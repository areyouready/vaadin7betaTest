package de.sebastian.CDITest.main.presenter;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import com.vaadin.ui.UI;

import de.sebastian.CDITest.backend.TestBackend;
import de.sebastian.CDITest.main.Window.MainWindow;
import de.sebastian.CDITest.second.SecondWindow;

@SessionScoped
public class MainWindowPresenter implements Serializable {

	private MainWindow mainWin;
	private Instance<MainWindow> instanceMainWin;
	private SecondWindow secWin;
	private TestBackend backend;

	@Inject
	public MainWindowPresenter(SecondWindow secWin,
			Instance<MainWindow> instanceMainWin, TestBackend backend) {
		this.secWin = secWin;
		this.instanceMainWin = instanceMainWin;
		this.backend = backend;
	}
	
	protected MainWindowPresenter() {
		
	}

	@PostConstruct
	public void initialize() {
		this.mainWin = instanceMainWin.get();
		mainWin.go();
	}

	public String getUser() {
		return backend.getUser();

	}

	public void openNewWindow() {
		UI.getCurrent().addWindow(secWin);
	}

}
