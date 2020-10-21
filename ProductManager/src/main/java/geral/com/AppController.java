package geral.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private ProdutoService service; 
	
	//Model é um auxiliar que ajudara a adicionar atributos a nossa view(front)
	
	@RequestMapping("/")
	public String showNewProdutoPage(Model model) {
		//cria um novo objeto na hora na tabela produto
		TableProduto produtoModel = new TableProduto();
		//coloca o objeto agora criado produtoModel na variavel produtoview
		model.addAttribute("produtoview", produtoModel);
		//direciona o /new
		return "new_produto";
	}
	
	//url save amigavel , método post
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	//insere o view na tabela por post
	public String saveProduto(@ModelAttribute("produtoview") TableProduto produto) {
		service.save(produto);
		
		return "redirect:/";
	}
	
	@GetMapping("/listar")
	public String pesquisar(Model model) {
		List<TableProduto> listaProdutos = service.listAll();
		model.addAttribute("listaprodutosview", listaProdutos);
		return "listar";
	}
	
	
//	// abrir pagina login
//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
		
//		// login invalido
//		@GetMapping("/login-error")
//		public String loginError(ModelMap model) {
//			model.addAttribute("alerta", "erro");
//			model.addAttribute("titulo", "Crendenciais inválidas!");
//			model.addAttribute("texto", "Login ou senha incorretos, tente novamente.");
//			model.addAttribute("subtexto", "Acesso permitido apenas para cadastros já ativados.");
//			return "login";
//		}	
	}
