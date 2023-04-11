package org.contact.controller;

import java.util.Map;

import org.contact.modelo.Contact;
import org.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/*
 * MAP, MODEL: SON TIPOS DE COLLECTIONS, PARAALMACENAR DATOS
 *  
 *  @RequestMapping: PERMITE ENCONTRAR UN RECURSO HTTP
 *  
 *  @ModelAttribute: RECUPERA LOS DATOS DEL MODELO, GetModel
 *  
 *  BindingResult: RECUPERA LOS DATOS EN FILAS Y COLUMNAS
 *  
 *  @PathVariable: RECUPERA EL VALOR DE UNA VARIABLE EN MEMORIA
 *  
 * */

@Controller
public class ContactController {

	@Autowired
	private ContactService service;
	
	@RequestMapping(value = "/index")
	public String listContacts(Map<String, Object>map)
	{
		map.put("contact", new Contact());
		map.put("contactList", service.listContacts());
		return "contactForms";
	}
	
	@RequestMapping (value = "/contact/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute Contact contact, BindingResult result)
	{
		
		service.addContact(contact);
		return "redirect:/index";
		
	}
	
	@RequestMapping (value = "delete/{id}")
	public String deleteContact(@PathVariable ("id") Integer id)
	{
		service.deleteContact(id);
		return "redirect:/index";
	}
	
	@RequestMapping (value = "/edit/{id}")
	public String updateContact (@PathVariable ("id") int id, Model model)
	{
		model.addAttribute("contact", service.getContactById(id));
		model.addAttribute("contactList", service.listContacts());
		return "contactForms";
	}
	
}











