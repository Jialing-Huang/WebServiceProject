package myWebServiceProject.Jialing.Rest;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import myWebServiceProject.Jialing.Entity.Customer;
import myWebServiceProject.Jialing.Entity.Customer.Gender;
import myWebServiceProject.Jialing.Entity.Payment;
import myWebServiceProject.Jialing.Entity.Payment.TypeOfCard;
import myWebServiceProject.Jialing.Entity.Address;
import myWebServiceProject.Jialing.Exception.CustomerNotFoundException;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	private ArrayList<Customer> customers;
	
	// We want to create the list of Customers only one time
	// in previous approach by each request every time new array of Customers was built
	// with @PostConstruct Customers initialization will happened only one time
	@SuppressWarnings("deprecation")
	@PostConstruct
	public void loadData() {

		customers = new ArrayList<Customer>();
			
		Address address1 = new Address(123,"Street A","Montreal","QC","canada","A1A2B2");
		Payment payment1 = new Payment(TypeOfCard.MASTER,12344321);
		Customer p1 = new Customer("Sheldon", "Couper", "1999-11-06", "Sheldon@gmail.com", "5141234567", Gender.F, payment1, address1);
	
		Address address2 = new Address(456,"Street B","Toronto","ON","canada","a1a1a1");
		Payment payment2 = new Payment(TypeOfCard.MASTER,12344567);	
		Customer p2 = new Customer("Penny", "Rossi", "1974-03-06", "Penny@gmail.com", "5142364578", Gender.F, payment2, address2);
				
		Address address3 = new Address(657,"Street C","Vancouver","BC","canada","c1c1c1");
		Payment payment3 = new Payment(TypeOfCard.VISA,12345678);		
		Customer p3 = new Customer("Leonard","Zack","1994-11-06","Leonard@gmail.com","345678898",Gender.M, payment3,address3);
						
		Address address4 = new Address(345,"Street D","Calgary","AB","canada","C6CY7Y");
		Payment payment4 = new Payment(TypeOfCard.VISA,12348765);		
		Customer p4 = new Customer("Shely","Sinck","1959-06-16","Shely@gmail.com","2345678910",Gender.F, payment4,address4);
						
		Address address5 = new Address(128,"Street E","Vancouver","BC","canada","c1c1c1");
		Payment payment5 = new Payment(TypeOfCard.GIFTCARD,0234432112);		
		Customer p5 = new Customer("Patrick","Sinck","1999-07-06","Patrick@gmail.com","1234567890",Gender.M, payment5,address5);
		
		customers.add(p1);
		customers.add(p2);
		customers.add(p3);
		customers.add(p4);
		customers.add(p5);
	}
	
	// define end point for "/customers" - return list of Customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customers;
	}
	
	// http://localhost:8080/03-REST-PathVariable/api/Customers/1
	// One at the end of URL is customerId and can be changed to other numbers
	// define end point for "/customers/{customerId}" - return one customer based on Id
	// customerId in the path should be the same as method argument
	
	@GetMapping("/customers/Id/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		if( (customerId >= customers.size()) || (customerId  < 0 ) ){
			throw new CustomerNotFoundException("Customer id not found -  " + customerId);
		}	
		return customers.get(customerId);
	}
	
	@GetMapping("/customers/city/{somecity}")
	public ArrayList<Customer> getCustomerByCity(@PathVariable String somecity) {
		ArrayList<Customer> cityList = new ArrayList<>();
		
		for(Customer item: customers) {
			if (item.getAddress().getCity().equals(somecity)){
				cityList.add(item);				
			}
		}
		
		if(cityList.size() > 0 ) {
			return cityList;
		}else {
			throw new CustomerNotFoundException("Not found item which contains  " + somecity);
		}
	}
	
	@GetMapping("/customers/sorted/family")	
	public ArrayList<Customer> sortCustomersByFamily() {
		Collections.sort(customers,new Comparator<Customer>() {
			@Override
			public int compare(Customer a, Customer b) {
				// TODO Auto-generated method stub
				return a.getFamily().compareToIgnoreCase(b.getFamily());
			}			
		});
		return customers;
	}
	
	@GetMapping("/customers/find/{family}")
	public ArrayList<Customer> getCustomerByFamily(@PathVariable String family) {
		ArrayList<Customer> familyList = new ArrayList<>();
		
		for(Customer item: customers) {
			if(item.getFamily().equals(family)) {
				familyList.add(item);
			}
		}
		
		if(familyList.size() > 0 ) {
			return familyList;
		}else {
			throw new CustomerNotFoundException("Not found item which contains  " + family);
		}
	}
	
	@GetMapping("/customers/typeofcard/{typeOfCard}/state/{state}")
	public ArrayList<Customer> getCustomerByCardAndState(@PathVariable TypeOfCard typeOfCard, @PathVariable String state) {
		ArrayList<Customer> resultlyList = new ArrayList<>();
		
		for(Customer item: customers) {
			if(item.getPayment().getTypeofcard().equals(typeOfCard) && item.getAddress().getState().equals(state)) {
				resultlyList.add(item);
			}
		}
		
		if(resultlyList.size() > 0 ) {
			return resultlyList;
		}else {
			throw new CustomerNotFoundException("Not found item which contains  " + typeOfCard + " and " + state);
		}
	}
	
	@GetMapping("/customers/delete/{gender}")
	public ArrayList<Customer> deleteCustomerByCardAndState(@PathVariable Gender gender) {
		ArrayList<Customer> newList = new ArrayList<>();
		
		for(Customer item: customers) {
			if(!item.getGender().equals(gender)) {
				newList.add(item);
//				int position = customers.indexOf(item);
//				newList.remove(position);
			}
		}
		
		if(newList.size() > 0 ) {
			return newList;
		}else {
			throw new CustomerNotFoundException("Since all customers are  " + gender + ", so all customers deleted. ");
		}
	}
}

