package com.exam.iot.servlet;

import com.exam.iot.model.Measurement;
import com.exam.iot.service.IoTService;
import com.exam.iot.util.HtmlView;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** Servlet que muestra en HTML la lista completa de mediciones registradas. */
@WebServlet(name = "ListMeasurementsServlet", urlPatterns = {"/list-measurements"})
public class ListMeasurementsServlet extends HttpServlet {

    private IoTService ioTService;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext servletContext = getServletContext();
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        this.ioTService = ctx.getBean(IoTService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Collection<Measurement> measurements = ioTService.getAllMeasurements();
        List<Measurement> list = new ArrayList<>(measurements);
        try (PrintWriter out = resp.getWriter()) {
            out.print(HtmlView.measurementsTable(list));
        }
    }
}
