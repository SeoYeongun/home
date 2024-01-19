package verify.exam07;

public class HttpServletExample {

	public static void main(String[] args) {
		method(new LoginServlet());
		method(new FileDownloadServlet());
	}

    public static void method(HttpServlet servlet) {//var HttpServlet servlet = new LoginServlet()
        servlet.service();
    }	
	
}
