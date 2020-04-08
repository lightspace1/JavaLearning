package redis.demo.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import redis.demo.domain.Province;
import redis.demo.service.ProvinceService;
import redis.demo.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/provinceServlet"} )
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // use service to check the result

        ProvinceService service = new ProvinceServiceImpl();
        List<Province> list = service.findAll();
        //serialize the list to json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
        //response result
        response.setContentType("application/json;charset=utf-8");
        response.getWriter()   .write(json);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
