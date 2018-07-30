
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SSE")
public class SSE extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SSE() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("utf-8");
        for (int i = 0; i < 5; i++) {
            // ָ���¼���ʶ
            response.getWriter().write("event:me\n");
            // ��ʽ: data: + ���� + 2���س�
            response.getWriter().write("data:" + i + "\n\n");
            response.getWriter().flush();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
