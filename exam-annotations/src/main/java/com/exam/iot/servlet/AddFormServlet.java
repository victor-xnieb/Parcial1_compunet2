package com.exam.iot.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.exam.iot.util.HtmlView;

/** Sirve un formulario HTML simple para probar el registro de mediciones desde el navegador. */
@WebServlet(name = "AddFormServlet", urlPatterns = {"/add-form", "/"})
public class AddFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.print(HtmlView.addForm());
        }
    }
}
