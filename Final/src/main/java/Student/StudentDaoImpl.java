package Student;
import com.alibaba.druid.pool.DruidDataSourceFactory;
 
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
 
/**
 * 创建数据访问接口实现类
 */
public class StudentDaoImpl implements StudentDao{
    private StudentDaoImpl(){
    }
 
    /**
     * 单例模式创建数据访问接口实现类
     * 保证只创建一个对象:构造方法私有、提供一个静态方法返回创建好的当前类对象
     */
    private static StudentDaoImpl studaoimp=null;
    public static  StudentDaoImpl getStudaoimp(){
        if(studaoimp==null){
            studaoimp=new StudentDaoImpl();
        }
        return studaoimp;
    }
 
 
    @Override
    /**
     * 从数据库查询所有学生信息返回集合中
     *
     */
    public List<StudentBean> getAllStudent() {
        List<StudentBean> studentlist=null;
        try {
            //数据库建立连接
        	Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","august");
            //查询总的行数
            PreparedStatement psta = conn.prepareStatement("select count(*) from student");
            //返回查询结果
            ResultSet rs = psta.executeQuery();
            rs.next();
            rs = psta.executeQuery();
            studentlist = new ArrayList<>();
            while (rs.next()){
                StudentBean stu = new StudentBean();
                stu.setStuid(rs.getLong(1));
                stu.setStuname(rs.getString(2));
                stu.setClasses(rs.getString(3));
                stu.setCourse(rs.getString(4));
                stu.setScore(rs.getString(5));
                stu.setDay(rs.getString(6));
                stu.setTime(rs.getString(7));
                stu.setStuaddress(rs.getString(8));
                studentlist.add(stu);
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentlist;
    }
 
    @Override
    /**
     * 添加学生信息
     *
     */
    public Boolean insertStudent(StudentBean studentBean) {
        boolean flag=false;
        try {
            String sql="insert into student values(null,?,?,?,?,?,?,?,?);";
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","august");
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setLong(1,studentBean.getStuid());
            ps.setString(2,studentBean.getStuname());
            ps.setString(3,studentBean.getClasses());
            ps.setString(4,studentBean.getCourse());
            ps.setString(5,studentBean.getScore());
            ps.setString(6,studentBean.getDay());
            ps.setString(7,studentBean.getTime());
            ps.setString(8,studentBean.getStuaddress());
            if(ps.executeUpdate()>0){
                flag=true;
            }
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
 
    @Override
    /**
     * 查询单个学生信息
     *
     */
    public StudentBean getOneStudent(long stuid) {
        StudentBean stu=null;
        try {
            String sql="select * from student where id=?;";
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","august");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1,stuid);
            ResultSet rs = ps.executeQuery();
 
            if(rs.next()){
                stu= new StudentBean();
                stu.setStuid(rs.getLong(2));
                stu.setStuname(rs.getString(3));
                stu.setClasses(rs.getString(4));
                stu.setCourse(rs.getString(5));
                stu.setScore(rs.getString(6));
                stu.setDay(rs.getString(7));
                stu.setTime(rs.getString(8));
                stu.setStuaddress(rs.getString(9));
            }
            rs.close();
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  stu;
    }
 
    @Override
    /**
     * 修改学生信息
     */
    public Boolean updateStudent(StudentBean studentBean) {
        boolean flag=false;
        try {
            String sql="update student set id=?,name=?,class=?,course=?,score=?,day=?,time=?,address=? where num=?;";
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","august");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1,studentBean.getStuid());
            ps.setString(2,studentBean.getStuname());
            ps.setString(3,studentBean.getClasses());
            ps.setString(4,studentBean.getCourse());
            ps.setString(5,studentBean.getScore());
            ps.setString(6,studentBean.getDay());
            ps.setString(7,studentBean.getTime());
            ps.setString(8,studentBean.getStuaddress());
            ps.setInt(9,studentBean.getNum());
            if(ps.executeUpdate()>0){
                flag=true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    @Override
    public Boolean checkStudent(StudentBean studentBean) {
        boolean flag=false;
        try {
            String sql="update student set name=?,class=? where id=?;";
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","august");
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1,studentBean.getStuname());
            ps.setString(2,studentBean.getClasses());
            ps.setLong(3,studentBean.getStuid());
            
            if(ps.executeUpdate()>0){
                flag=true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    @Override
    public Boolean dmarkStudent(StudentBean studentBean) {
        boolean flag=false;
        try {
            String sql="update student set score=? where id=? and course=?;";
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","august");
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1,studentBean.getScore());
            ps.setLong(2,studentBean.getStuid());
            ps.setString(3,studentBean.getCourse());
            
            if(ps.executeUpdate()>0){
                flag=true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    @Override
    /**
     * 删除学生
     */
    public Boolean removeStudent(long stuid) {
        boolean flag=false;
        try {
            String sql="delete from student where num=?;";
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","august");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1,stuid);
            if(ps.executeUpdate()>0){flag=true;}
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
	@Override
	public Boolean updateStudent(long stuid) {
		// TODO Auto-generated method stub
		return null;
	}
}