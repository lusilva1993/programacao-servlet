package br.com.ada.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastroLocacao")
public class CadastroLocacao extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomeCliente  = req.getParameter("nomeCliente");
        String cpfCnpj = req.getParameter("cpfCnpj");
        String telefone = req.getParameter("telefone");
        String marca = req.getParameter("marca");
        String modelo = req.getParameter("modelo");
        String placa = req.getParameter("placa");

        if(nomeCliente.equals("") ||cpfCnpj.equals("") || telefone.equals("") || marca.equals("") || modelo.equals("") || placa.equals("")){
            resp.setContentType("text/html");
            resp.getWriter().println("<h3>Dados obrigatórios não preenchidos!</h3>");

        }else {
            req.setAttribute("nomeCliente", nomeCliente);
            req.setAttribute("cpfCnpj", cpfCnpj);
            req.setAttribute("telefone", telefone);
            req.setAttribute("marca",marca);
            req.setAttribute("modelo",modelo);
            req.setAttribute("placa",placa);

            RequestDispatcher rd = req.getRequestDispatcher("data.jsp");
            rd.forward(req, resp);
        }
    }
}

class Locacao{
    private String nomeCliente;
    private String cpfCnpj;
    private String telefone;
    private String marca;
    private String modelo;
    private String ano;
}