package com.winter.app.departments;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DepartmentUpdateController
 */
@WebServlet("/dept/update")
public class DepartmentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("departmentId");
		int n = Integer.parseInt(id);
		
		DepartmentDAO dao = new DepartmentDAO();
		
		try {
			DepartmentDTO departmentDTO = dao.detail(n);
			request.setAttribute("dto", departmentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//JSP의 경로명을 써야 한다
		RequestDispatcher view	= request.getRequestDispatcher("/WEB-INF/views/dept/update.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		String id = request.getParameter("departmentId");
		int i = Integer.parseInt(id);
		String n = request.getParameter("departmentName");
		String m = request.getParameter("managerId");
		int mi = Integer.parseInt(m);
		String l = request.getParameter("locationId");
		int lm= Integer.parseInt(l);
		
		departmentDTO.setDepartmentId(i);
		departmentDTO.setDepartmentName(n);
		departmentDTO.setManagerId(mi);
		departmentDTO.setLocationId(lm);
		
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		
		try {
			int result = departmentDAO.update(departmentDTO);
			
			if(result>0) {
				response.sendRedirect("./list");
			}else {
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
