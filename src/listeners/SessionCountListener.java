package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionCountListener implements ServletContextListener, HttpSessionListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Context Initialized");
		ServletContext ctx = sce.getServletContext();
		ctx.setAttribute("count", 0); // autoboxing
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context Destroyed");
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext ctx = se.getSession().getServletContext();
		Integer count = (Integer) ctx.getAttribute("count");
		ctx.setAttribute("count", count + 1);
		System.out.println("Session Created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext ctx = se.getSession().getServletContext();
		Integer count = (Integer) ctx.getAttribute("count");
		ctx.setAttribute("count", count - 1);
		System.out.println("Session Destoryed");
	}

}
