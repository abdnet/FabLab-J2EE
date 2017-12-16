package org.sid;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GestionCatalogueProduitApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(GestionCatalogueProduitApplication.class, args);
		ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		produitRepository.save(new Produit("Prod 1",314,122));
		produitRepository.save(new Produit("Prod 2",14,1));
		produitRepository.save(new Produit("Prod 3",31,2));
		produitRepository.save(new Produit("Prod 4",341,22));
		produitRepository.save(new Produit("Prod 5",314,11));
		produitRepository.save(new Produit("Prod 6",134,112));
		produitRepository.findAll().forEach(s->System.out.println(s));

	}
}
