package upload;

 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
@WebServlet(description = "Upload2Servlet", urlPatterns = { "/Upload2Servlet" })
public class Upload2Servlet extends HttpServlet {
 	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) {} else {
					String name = item.getName();
					name = name.substring(name.lastIndexOf("\\") + 1);
					long upFileSize=item.getSize();
					String type=item.getContentType();
					FileOutputStream fos = new FileOutputStream(
							"C:\\Users\\28612\\eclipse\\uploadFIie\\"+name);
					IOUtils.copy(item.getInputStream(), fos);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/upload/download.jsp").forward(request,response);
	} 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		doGet(request, response);
	}
 
}