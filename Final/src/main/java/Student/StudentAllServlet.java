package Student;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
 
public class StudentAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentServiceImpl studentService = new StudentServiceImpl(StudentDaoImpl.getStudaoimp());
        List<StudentBean> studentBeanList = studentService.queryAllStudent();
        req.setAttribute("studentBeanList",studentBeanList);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }
}