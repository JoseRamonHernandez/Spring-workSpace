package org.contact.service;

import java.util.List;

import org.contact.dao.ContactDao;
import org.contact.modelo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactServiceImpl implements ContactService {


	@Autowired
	private ContactDao dao;
	
	
	@Transactional
	public void addContact(Contact contact) {
		
		dao.addContact(contact);
		

	}

	@Transactional
	public List<Contact> listContacts() {
		// TODO Auto-generated method stub
		return dao.listContacts();
	}

	@Transactional
	public Contact getContactById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getContactById(id);
	}

	@Transactional
	public void deleteContact(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteContact(id);
	}

}
