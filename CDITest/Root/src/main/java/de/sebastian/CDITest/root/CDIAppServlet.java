package de.sebastian.CDITest.root;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;

@WebServlet(urlPatterns = "/*")
public class CDIAppServlet extends VaadinServlet {

	@Inject
	private CDIUIProvider cdiUIProvider;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		logger().info("VaadinCDIServlet initialized");
		this.registerUIProvider();
	}

	private void registerUIProvider() {

		super.getService().addSessionInitListener(new SessionInitListener() {
			@Override
			public void sessionInit(
					SessionInitEvent vaadinSessionInitializeEvent)
					throws ServiceException {
				VaadinSession vaadinSession = vaadinSessionInitializeEvent
						.getSession();
				VaadinService service = vaadinSessionInitializeEvent
						.getService();
				logger().info("sessionInitialized");
				logger().info("Registering ui CDIUIProvider: " + cdiUIProvider);
				service.addUIProvider(vaadinSession, cdiUIProvider);
			}
		});
	}

	private static Logger logger() {
		return Logger.getLogger(CDIAppServlet.class.getCanonicalName());
	}

}