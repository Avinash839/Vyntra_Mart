package com.project.vyntramart.controller;

import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.vyntramart.controller.dto.NewUserRegistration;
import com.project.vyntramart.model.Cart;
import com.project.vyntramart.model.CheckOuts;
import com.project.vyntramart.model.Products;
import com.project.vyntramart.model.Wishlist;
import com.project.vyntramart.repositories.CartRepository;
import com.project.vyntramart.repositories.CheckOutsrepository;
import com.project.vyntramart.repositories.ProductRepository;
import com.project.vyntramart.repositories.UserRepository;
import com.project.vyntramart.repositories.WiahlistRepository;
import com.project.vyntramart.service.ProductsService;
import com.project.vyntramart.service.UserService;

import antlr.collections.List;

@Controller
public class CustomerController {

	@Autowired
	  UserRepository rep;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	WiahlistRepository wishlistRepository;
	
	@Autowired
	ProductsService productsService;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/viewcart")
	public String viewcart(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			ArrayList<Long> li= new ArrayList<>();
			String username=(((UserDetails) principal).getUsername());
			ArrayList<Cart> carts=new ArrayList<>();
			
			for(Cart cart:(ArrayList<Cart>) cartRepository.findAll()) {
				if(cart.getUser_id()==rep.findByEmail(username).getId()) {
					carts.add(cart);
					li.add(cart.getProduct_id());
					
				}
			}
			Iterable<Long> ids=li;
					
			if(li.size()==0) {
				return "noproducts";
			}
			else
			model.addAttribute("mycart", productRepository.findAllById(ids));
			return "mycart";
		}
		return "";
	}
	@GetMapping("/deletefromcart/{id}")
	public String deletefromcart(@PathVariable (value="id") Long id,Model model) {
		System.out.println("deleteMapping");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			String username=(((UserDetails) principal).getUsername());
			ArrayList<Cart> carts=null;
			for(Cart cart:(ArrayList<Cart>) cartRepository.findAll()) {
				if(cart.getUser_id()==rep.findByEmail(username).getId() && cart.getProduct_id()==id) {
					cartRepository.deleteById(cart.getId());
				}
			}
			model.addAttribute("mycart", carts);
			return "productremoved";
		}
		return "";
	}
	
	@GetMapping("/viewProduct/{id}")
	public String viewproduct(@PathVariable (value="id") Long id,Model model) {
		
		model.addAttribute("product", productsService.getProductById(id));
		return "productDetails";
	}
	@GetMapping("/addtocart/{id}")
	public String addtocart(@PathVariable (value="id") Long id,Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
		 
		   ArrayList<Cart> carts =null;
		   carts=(ArrayList<Cart>) cartRepository.findAll();
		   for(Cart cart : carts) {
			   if(    cart.getUser_id()==rep.findByEmail(username).getId() && cart.getProduct_id()==id) {
				   return "already";
			   }
		   }
		  Cart c1=new Cart(rep.findByEmail(username).getId(),id);
//				  c1.setProduct_id(id);
//				  c1.setUser_id(rep.findByEmail(username).getId());
		  
		 cartRepository.save(c1);
		 
		  
		} else {
		  String username = principal.toString();
		}
		
		model.addAttribute("product", productsService.getProductById(id));
		return "productDetails";
	}
	
	@GetMapping("/viewwishlist")
	public String viewwishlist(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			String username=(((UserDetails) principal).getUsername());
			
			ArrayList<Long> li=new ArrayList<>();
			
			ArrayList<Wishlist> wishlists=new ArrayList<>();
			for(Wishlist wishlist:(ArrayList<Wishlist>) wishlistRepository.findAll()) {
				if(wishlist.getUser_id()==rep.findByEmail(username).getId()) {
					wishlists.add(wishlist);
					li.add(wishlist.getProduct_id());
				}
			}
			Iterable<Long> ids=li;
			
			model.addAttribute("mywishlist",productRepository.findAllById(ids));
			return "mywishlist";
		}
		return "";
	}
	@GetMapping("/deletefromwishlist/{id}")
	public String deletefromwishlist(@PathVariable (value="id") Long id,Model model) {
		System.out.println("deleteMapping");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			String username=(((UserDetails) principal).getUsername());
			ArrayList<Wishlist> wishlists=null;
			for(Wishlist wishlist:(ArrayList<Wishlist>) wishlistRepository.findAll()) {
				if(wishlist.getUser_id()==rep.findByEmail(username).getId() && wishlist.getProduct_id()==id) {
					wishlistRepository.deleteById(wishlist.getId());
				}
			}
			model.addAttribute("mycart", wishlists);
			return "productremoved";
		}
		return "";
	}
	@GetMapping("/addtowishlist/{id}")
	public String addtowishlist(@PathVariable (value="id") Long id,Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
		 
		   ArrayList<Wishlist> wishlists =null;
		   wishlists=(ArrayList<Wishlist>) wishlistRepository.findAll();
		   for(Wishlist wishlist : wishlists) {
			   if(    wishlist.getUser_id()==rep.findByEmail(username).getId() && wishlist.getProduct_id()==id) {
				   return "already";
			   }
		   }
		  Wishlist c1=new Wishlist(rep.findByEmail(username).getId(),id);
//				  c1.setProduct_id(id);
//				  c1.setUser_id(rep.findByEmail(username).getId());
		  
		 wishlistRepository.save(c1);
		 
		  
		} else {
		  String username = principal.toString();
		}
		
		model.addAttribute("product", productsService.getProductById(id));
		return "productDetails";
	}
	
	@GetMapping("/checkOutCart" )
	public String checkOutCart(Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			ArrayList<Long> li= new ArrayList<>();
			String username=(((UserDetails) principal).getUsername());
			ArrayList<Cart> carts=new ArrayList<>();
			
			for(Cart cart:(ArrayList<Cart>) cartRepository.findAll()) {
				if(cart.getUser_id()==rep.findByEmail(username).getId()) {
					carts.add(cart);
					li.add(cart.getProduct_id());
					
				}
			}
			Iterable<Long> ids=li;
					
			if(li.size()==0) {
				return "noproducts";
			}
			else
			model.addAttribute("cartProducts", productRepository.findAllById(ids));
			return "checkOutCart";
		}
		return "";
	
		
	}
	
	@ModelAttribute("checkOuts")
	public CheckOuts new_user() {
		return new CheckOuts();
	}
	
	@Autowired
	CheckOutsrepository checkoutrepository;
	
	
	@PostMapping(value="/orderthis")
	public String registerUserAccount(@ModelAttribute("checkOuts") CheckOuts checkout) {
		System.out.println("The picture link is given by th elink is "+checkout.getPic1());
		checkoutrepository.save(checkout);
		return "redirect:/checkOutCart?success";
	}
	
	@GetMapping("/order")
	public String orderall(Model model,HttpServletRequest req) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String address=req.getParameter("address");
		
		System.out.print("The order shipped to addresssss    "+address);
		String username;
		ArrayList<Cart> carts;
		if(principal instanceof UserDetails) {
			ArrayList<Long> li= new ArrayList<>();
			username=(((UserDetails) principal).getUsername());
			carts=new ArrayList<>();
			
			for(Cart cart:(ArrayList<Cart>) cartRepository.findAll()) {
				if(cart.getUser_id()==rep.findByEmail(username).getId()) {
					carts.add(cart);
					li.add(cart.getProduct_id());
					
				}
			}
			Iterable<Long> ids=li;
					
			if(li.size()==0) {
				return "noproducts";
			}
			else {
			model.addAttribute("cartProducts", productRepository.findAllById(ids));
			
			for(Products p:  productRepository.findAllById(ids)) {
				CheckOuts c1=new CheckOuts();
				c1.setPic1(p.getPic1());
				c1.setProduct_id(p.getProduct_id());
				c1.setRate(p.getPrice()-p.getPrice()*p.getDiscount()/100);
				c1.setUser_id(rep.findByEmail(username).getId());
				c1.setStatus("order placed");
				c1.setShipping_address(address);
				checkoutrepository.save(c1);
			}
			Iterable<Cart> entity=carts;
			cartRepository.deleteInBatch(entity);
			return "redirect:/";
			}
		}
		return "";
		
		//return "noproducts";
	}
	
	@GetMapping("/viewmyorders")
	public String viewmyorders(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if(principal instanceof UserDetails) {
			username=(((UserDetails) principal).getUsername());
		}
		ArrayList<CheckOuts> one=new ArrayList<>();
		
		for(CheckOuts c: checkoutrepository.findAll()) {
			if(c.getUser_id()==rep.findByEmail(username).getId()) {
				one.add(c);
			}
		}
		model.addAttribute("orders",one);
		return "myorders";
	}
	
	
	
	
	

	
	
}
