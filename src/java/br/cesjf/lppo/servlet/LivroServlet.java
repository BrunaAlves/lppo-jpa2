package br.cesjf.lppo.servlet;

import br.cesjf.Livro;
import br.cesjf.lppo.dao.LivroJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet(name = "LivroServlet", urlPatterns = {"/editar.html", "/excluir.html"})
public class LivroServlet extends HttpServlet {

    @PersistenceUnit(unitName = "lppo-2017-1-jpa2PU")
    EntityManagerFactory emf;

    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().contains("/editar.html")) {
            doEditarGet(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().contains("/editar.html")) {
            doEditarPost(request, response);
        }

    }

    private void doEditarGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            LivroJpaController dao = new LivroJpaController(ut, emf);
            Long id = Long.parseLong(request.getParameter("id"));
            Livro livro = dao.findLivro(id);
            request.setAttribute("livro", livro);
            request.getRequestDispatcher("WEB-INF/editar-livro.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("listar.html");

        }
    }

    private void doEditarPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            LivroJpaController dao = new LivroJpaController(ut, emf);
            Long id = Long.parseLong(request.getParameter("id"));
            Livro livro = dao.findLivro(id);
            livro.setTitulo(request.getParameter("titulo"));
            livro.setAutor(request.getParameter("autor"));
            livro.setAno(Integer.parseInt(request.getParameter("ano")));
            dao.edit(livro);
            response.sendRedirect("listar.html");

        } catch (Exception e) {
            response.sendRedirect("listar.html");

        }
    }

}
