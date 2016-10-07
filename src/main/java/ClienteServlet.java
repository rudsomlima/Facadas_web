import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;

@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/cliente","/Cliente"})
public class ClienteServlet extends HttpServlet {
	
	List<Cliente> lista = new ArrayList<>();
	
	public ClienteServlet() {
		System.out.println("Construindo Servlet...");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Inicializando Servlet");
	}
	
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		System.out.println("Chamando o service...");
//		super.service(arg0, arg1);
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("lista", lista);
		dispatcher.forward(req, resp);
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Recebendo o email
		String email = req.getParameter("email");

		//COlocando o e-mail em um objeto cliente
		Cliente cli = new Cliente();
		cli.setEmail(email);
				
		//Adicionando o cliente na lista de clientes
		lista.add(cli);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("msg", "Cadastrado com sucesso!");
		req.setAttribute("lista", lista);
		dispatcher.forward(req, resp);
				
		//resp.sendRedirect("cliente");		
		//resp.setCharacterEncoding("UTF-8");
		//resp.getWriter().print("Chamou pelo método POST enviando e-mail:"+ email);

	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método DELETE");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet será destruído...");
		super.destroy();
	}

}
