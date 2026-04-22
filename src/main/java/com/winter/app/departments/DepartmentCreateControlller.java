package com.winter.app.departments;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DepartmentCreateController
 */
@WebServlet("/dept/create")
public class DepartmentCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentCreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/dept/create.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("departmentName");
		String m = request.getParameter("managerId");
		String l = request.getParameter("locationId");
		
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartmentName(name);
		departmentDTO.setManagerId(Integer.parseInt(m));
		departmentDTO.setLocationId(Integer.parseInt(l));
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		try {
			int result =departmentDAO.create(departmentDTO);
			if(result > 0) {
				response.sendRedirect("/dept/list");
				
			}else {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/dept/list.jsp");
				view.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
