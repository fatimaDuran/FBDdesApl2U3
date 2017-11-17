package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiscoDAO;
import dao.DiscoDAOImpl;
import model.Disco;

/**
 * Servlet implementation class DiscoController
 */
@WebServlet("/DiscoController")
public class DiscoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Disco disco;
	private List<Disco> discos;
	private DiscoDAO discoDAO;
	private List<String> ids = new ArrayList<String>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscoController() {
        super();
        disco = new Disco();
        discos = new ArrayList<Disco>();
        discoDAO = new DiscoDAOImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("btn_save") != null) {
			disco.setTitulo(request.getParameter("titulo"));
			disco.setFecha(request.getParameter("fecha"));
			disco.setTipoGrabacion(request.getParameter("tipograbacion"));
			disco.setCanciones(Integer.parseInt(request.getParameter("canciones")));
			
			System.out.println("save");
			if (disco.getId()==0) {
				System.out.println("save");
				discoDAO.createDisco(disco);
			} else {
				System.out.println("save");
				discoDAO.updateDisco(disco);
			}
			discos = discoDAO.readAllDiscs();
			request.setAttribute("discos", discos);
			request.getRequestDispatcher("disco_list.jsp").forward(request, response);
		}else if(request.getParameter("btn_new")!=null) {
			disco = new Disco();
			request.getRequestDispatcher("disco_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_edit")!=null) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				disco = discoDAO.readDisco(id);	
			}catch (IndexOutOfBoundsException e) {
				disco = new Disco();
			}
		 request.setAttribute("disco", disco);
		 request.getRequestDispatcher("disco_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_delete")!=null) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				discoDAO.deleteDisco(id);
				discos = discoDAO.readAllDiscs();
			}catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("discos", discos);
			request.getRequestDispatcher("disco_list.jsp").forward(request, response);
		}else {
			discos = discoDAO.readAllDiscs();
			request.setAttribute("discos", discos);
			request.getRequestDispatcher("disco_list.jsp").forward(request, response);
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
