package Student;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
 
public class ModifyToServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String stuid = req.getParameter("stuid");
    	int b =Integer.parseInt(stuid);
        StudentServiceImpl studentService = new StudentServiceImpl(StudentDaoImpl.getStudaoimp());
        StudentBean student = studentService.queryOneStudent(b);
        req.setAttribute("student",student);
        req.getRequestDispatcher("/modify.jsp").forward(req,resp);
    }
}