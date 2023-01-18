package upload;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
@WebServlet(description = "DownloadServlet", urlPatterns = { "/DownloadServlet" })
public class DownloadServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.得到要下载的文件名称
		String filename = request.getParameter("filename");
		filename = new String(filename.getBytes("iso8859-1"), "utf-8"); // 解决中文乱码
		File file = new File("C:\\Users\\28612\\eclipse\\uploadFIie\\", filename);
		if (file.exists()) {
			String mimeType = this.getServletContext().getMimeType(filename);
			response.setContentType(mimeType);
			String agent = request.getHeader("user-agent");
			if (agent.contains("MSIE")) {
				// IE浏览器
				filename = URLEncoder.encode(filename, "utf-8");
 
			} else if (agent.contains("Firefox")) {
				// 火狐浏览器
				Base64 base64Encoder = new Base64();
				filename = "=?utf-8?B?"
						+ base64Encoder.encode(filename.getBytes("utf-8"))
						+ "?=";
			} else {
				// 其它浏览器
				filename = URLEncoder.encode(filename, "utf-8");
			}
			response.setHeader("content-disposition", "attachment;filename="
					+ filename);
 
			FileInputStream fis = new FileInputStream(file); // 读取要下载文件的内容
			OutputStream os = response.getOutputStream();// 将要下载的文件内容通过输出流写回到浏览器
			int len = -1;
			byte[] b = new byte[1024 * 100];
 
			while ((len = fis.read(b)) != -1) {
				os.write(b, 0, len);
				os.flush();
			}
			os.close();
			fis.close();
		} else {
			throw new RuntimeException("下载资源不存在");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
 
}