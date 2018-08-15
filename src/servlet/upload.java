package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class upload extends HttpServlet {
	
public static void main(String[] args) {
	System.out.println("ssss");
}
	    
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            String filepath = this.getServletContext().getRealPath("/uploadFile/");    //容器相对路径            
 
           File ww = new File(filepath);
            if(! ww.exists()) {
	             ww.mkdirs();
           }
 
	        File tmp = new File("d:\\tmp\\");
	        if(! tmp.exists()) {
	            tmp.mkdirs();
	        }
	        
	        
	        DiskFileItemFactory factory = new DiskFileItemFactory();    //创建磁盘工厂
	        factory.setRepository(tmp);    //文件缓存路径
	        factory.setSizeThreshold(10 * 1096 );//10*1096b        
	        ServletFileUpload sfu = new ServletFileUpload(factory);        //创建处理工具
	        sfu.setSizeMax(10*1024*1024); //服务器端可以接收的最大文件大小，-1表示无上限
	       
	        
	        String filename = null;
	        String ff="";
	        try {
	            List<FileItem> list = sfu.parseRequest(request);        //解析
	            for(FileItem item:list){
	            if(item.isFormField()) 
	            	continue;
	            filename = item.getName();
	            if(filename.equals("")) {
	                 return ;
	            }            
	            int pos = filename.lastIndexOf(".");   
	            //取图片文件格式
	            if(pos > 0) {
	                Date date = new Date();
	                ff= date.getTime()+filename.substring(pos);
	                filename =filepath+'/'+ff;
	            }
	            item.write(new File(filename));    //写到磁盘
	            String p= this.getServletContext().getContextPath()+"/uploadFile/"+ff;//网络完整路径
	 	       request.getSession().setAttribute("picurl", p);
	 	       
	 	       request.getSession().setAttribute("picok", 2);
	            }
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	      
	        response.sendRedirect("index.jsp");
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
