package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuardarFormulario
 */
@WebServlet("/GuardarFormulario")
/*Servlet para almacenar la informacion del cliente
 * @author Julián Vásquez G julivas96@gmail.com
 *  
 */
public class GuardarFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarFormulario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = null;
		String cedula = request.getParameter("cedula");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("correo");
		pw= response.getWriter();
		//pw.println("<b>La cedula ingresada es: "+cedula+" <br/>El nombre es: "+nombre+" <br/>El apellido: "+apellido+" </br>El correo: "+correo+"</b>");
		pw.println("<table border=\"1\" width=\"100%\" cellspacing=\"0\" cellpadding=\"10px\">\n" + 
				"		<tr>\n" + 
				"			<th>Cedula</th>\n" + 
				"			<th>Nombre</th>\n" + 
				"			<th>Apellido</th>\n" + 
				"			<th>Correo</th>\n" + 
				"		</tr>\n" + 
				"		<tr>\n" + 
				"			<td ><center>"+cedula+"</center></td>\n" + 
				"			<td ><center>"+nombre+"</center></td>\n" + 
				"			<td ><center>"+apellido+"</center></td>\n" + 
				"			<td ><center>"+correo+"</center></td>\n" +
				"		</tr>\n" + 
				"		</table>");
		pw.close();
	}

}
