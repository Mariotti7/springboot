package com.metodosave.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // anotação muda quando tem o thymleaf
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@RequestMapping("/")
	public String viewHomePage(Model mmodel) {
		return "redirect:/new/";
	}
	
	@RequestMapping("/new")
	public String showNewProdutoPage(Model model) {
		Produto produto = new Produto();
		model.addAttribute("produtoview", produto);
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduto(@ModelAttribute("produtoview") Produto produto) {
		service.save(produto);
		
		return "redirect:/";
	}
	
//	@RequestMapping("/edit/{id}")
//	public ModelAndView showEditProdutoPage(@PathVariable(name = "id") int id) {
//		ModelAndView mav = new ModelAndView("edit_produto");
//		Produto produto = service.get(id);
//		mav.addObject("produto", produto);
//		
//		return mav;
//	}
//	
//	@RequestMapping("/delete/{id}")
//	public String deleteProduto(@PathVariable(name = "id") int id) {
//		service.delete(id);
//		return "redirect:/";	
		
//		@RequestMapping("/")
//		public String viewHomePage(Model model) {
//			List<Produto> listaProdutos = service.listAll();
//			model.addAttribute("listaProdutos", listaProdutos);
//			return "index";
		
//	}

}
