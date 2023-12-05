package until;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateSessionFactory {
	private static final SessionFactory sessionfactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error build sessionfactory");
			return null;
		}
	}
	
	public static SessionFactory getsessionfactory() {
		return sessionfactory;
	}
	
	public static void shutdow() {
		getsessionfactory().close();
	}
}
