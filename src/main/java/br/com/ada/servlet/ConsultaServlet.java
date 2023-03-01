package br.com.ada.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/consultaServlet")
public class ConsultaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Object nomeCliente = req.getSession().getAttribute("nomeCliente");
        if(Objects.nonNull(nomeCliente)){
            String nomeEmTexto  = String.valueOf(nomeCliente);
            out.println("<h1>" + nomeEmTexto + "</h1>");
        } else{
            out.println("<h1>Não há dados na sessão </h1>");
        }
    }
}