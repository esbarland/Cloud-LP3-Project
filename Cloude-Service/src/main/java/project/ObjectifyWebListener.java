package project;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.googlecode.objectify.ObjectifyService;

import model.Account;
import model.Approval;

@WebListener
public class ObjectifyWebListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent event) {
    ObjectifyService.init();
    ObjectifyService.register(Account.class);
    ObjectifyService.register(Approval.class);
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
  }
}