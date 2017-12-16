package org.sid.web;

import java.util.List;
import java.util.Set;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import scala.annotation.meta.setter;

@Controller
public class ProduitController {
	@Autowired
	//injection de dependence
	private ProduitRepository produitRepository;
	
	@RequestMapping(value="/index")
	public String index(Model model,
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="size",defaultValue="5")int s,
			@RequestParam(defaultValue="") String mc){
		Page<Produit> produits= produitRepository.chercher("%"+mc+"%",new PageRequest(p, s));
		model.addAttribute("ListProduit",produits.getContent());
		int[] pages=new int[produits.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("currentp",p);
		model.addAttribute("motCle",mc);
		return "produits";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(Long id,String mc , int page){
		produitRepository.delete(id);
		return "redirect:/index?mc="+mc+"&page="+page;
	}

}
