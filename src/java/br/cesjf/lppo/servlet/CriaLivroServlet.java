package br.cesjf.lppo.servlet;

import br.cesjf.Livro;
import br.cesjf.lppo.dao.LivroJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@WebServlet(name = "CriaLivroServlet", urlPatterns = {"/criar.html"})
public class CriaLivroServlet extends HttpServlet {

    @PersistenceUnit(unitName = "lppo-2017-1-jpa2PU")
    EntityManagerFactory emf;

    @Resource(name = "java:comp/UserTransation")
    UserTransaction ut;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Livro livro1 = new Livro();
        livro1.setTitulo(request.getParameter("titulo"));
        livro1.setAno(Integer.parseInt(request.getParameter("ano")));
        livro1.setAutor(request.getParameter("autor"));

        LivroJpaController dao = new LivroJpaController(ut, emf);
        try {
            dao.create(livro1);
            response.sendRedirect("listar.html");
        } catch (Exception ex) {
            Logger.getLogger(CriaLivroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/novo-livro.jsp").forward(req, resp);

    }
    
    
    
      
    
}
