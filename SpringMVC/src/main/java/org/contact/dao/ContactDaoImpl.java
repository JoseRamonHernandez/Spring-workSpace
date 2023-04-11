package org.contact.dao;

import java.util.List;

import org.contact.modelo.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDaoImpl implements ContactDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public void addContact(Contact contact) {
		
		try {
			
			sessionFactory.getCurrentSession().saveOrUpdate(contact);
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> listContacts() {
		
		List<Contact> contacts = null;
		
		try {
			
			contacts = (List<Contact>)
			sessionFactory.getCurrentSession().createQuery("from Contact").list();
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		return contacts;
	}

	
	@Override
	public Contact getContactById(Integer id) {
		
		Contact contact = null;
		
		try {
			
			contact = (Contact)
			sessionFactory.getCurrentSession().get(Contact.class, id);
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		return contact;
	}
	
	
	
	@Override
	public void deleteContact(Integer id) {
		
		Contact contact = null;
		
		try {
			
			contact = (Contact)
			sessionFactory.getCurrentSession().get(Contact.class, id);
			sessionFactory.getCurrentSession().delete(contact);
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}

	}

}
