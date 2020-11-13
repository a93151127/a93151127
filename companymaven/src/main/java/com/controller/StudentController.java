package com.controller;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import model.Menu;

@Controller
@RequestMapping("/Menu")
public class StudentController {

	@RequestMapping(method = RequestMethod.GET)
	public String listStudent(ModelMap model) {
		List<Menu> data = getAll();
		System.out.println(data);
		model.addAttribute("message", data);
		return "showStudent";
	}

	List<Menu> getAll() {
		Configuration configObj = new Configuration();
		configObj.addClass(model.Menu.class);
		configObj.configure("/model/hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();
		Session session = null;
		session = configObj.buildSessionFactory(serviceRegistryObj).openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			List data = session.createQuery("FROM Menu").list();
			for (Iterator iterator = data.iterator(); iterator.hasNext();) {
				Menu st = (Menu) iterator.next();
				System.out.print("r1: " + st.getR1());
				System.out.print("  r2: " + st.getR2());
				System.out.print("    r3: " + st.getR3());
				System.out.print("      r4: " + st.getR4());
				System.out.println("      r5: " + st.getR5());
			}
			tx.commit();
			return data;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

	public void addStu(Menu stu) {
		Configuration configObj = new Configuration();
		configObj.addClass(model.Menu.class);
		configObj.configure("/model/hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();
		Session sessionObj = null;
		// Creating Hibernate SessionFactory Instance
		try {
			sessionObj = configObj.buildSessionFactory(serviceRegistryObj).openSession();
			sessionObj.beginTransaction();
			sessionObj.save(stu);

			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();

		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	@RequestMapping(value = "/addMenu", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute("a") Menu stu) {
		System.out.println("stu obj:" + stu);
		addStu(stu);		
		return  new ModelAndView("showStudent","message",getAll());

	}
	public void updateStu(Menu stu) {
		Configuration configObj = new Configuration();
		configObj.addClass(model.Menu.class);
		configObj.configure("/model/hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();
		Session sessionObj = null;
		// Creating Hibernate SessionFactory Instance
		try {
			sessionObj = configObj.buildSessionFactory(serviceRegistryObj).openSession();
			sessionObj.beginTransaction();
			sessionObj.update(stu);

			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();

		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}
	@RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute("b") Menu stu) {
		System.out.println("stu obj:" + stu);
		updateStu(stu);		
		return  new ModelAndView("showStudent","message",getAll());

	}
	public void deleteStu(Menu stu) {
		Configuration configObj = new Configuration();
		configObj.addClass(model.Menu.class);
		configObj.configure("/model/hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();
		Session sessionObj = null;
		// Creating Hibernate SessionFactory Instance
		try {
			sessionObj = configObj.buildSessionFactory(serviceRegistryObj).openSession();
			sessionObj.beginTransaction();
			sessionObj.delete(stu);

			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();

		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();

			}
		}
	}
	@RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
	public ModelAndView deleteStudent(@ModelAttribute("d") Menu stu) {
		System.out.println("stu obj:" + stu);
		deleteStu(stu);		
		return  new ModelAndView("showStudent","message",getAll());

	}
}
