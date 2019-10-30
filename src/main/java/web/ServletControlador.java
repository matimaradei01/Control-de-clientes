package web;

import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest reque, HttpServletResponse respo) throws ServletException, IOException {
        List<Cliente> listaClientes = new conecction.ConexionDaoJDBC().listar();

        reque.setAttribute("lista", listaClientes);
        reque.getRequestDispatcher("cliente.jsp").forward(reque, respo);

    }
}
