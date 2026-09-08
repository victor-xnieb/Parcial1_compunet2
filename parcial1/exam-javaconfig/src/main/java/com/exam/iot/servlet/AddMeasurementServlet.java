package com.exam.iot.servlet;

import com.exam.iot.model.Measurement;
import com.exam.iot.service.IoTService;
import com.exam.iot.service.exception.DeviceNotFoundException;
import com.exam.iot.service.exception.DuplicateTimestampException;
import com.exam.iot.service.exception.InvalidIntervalException;
import com.exam.iot.service.exception.OutOfRangeException;
import com.exam.iot.util.HtmlView;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet encargado de agregar una medicion a un dispositivo (por id).
 * Ante cualquier violacion de las reglas de negocio, responde con una
 * vista HTML de alerta en vez de lanzar el error al contenedor.
 */
@WebServlet(name = "AddMeasurementServlet", urlPatterns = {"/add-measurement"})
public class AddMeasurementServlet extends HttpServlet {

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
        // Permite probar tambien por query string desde el navegador: ?assetId=1&timestamp=6000&valor=27.1
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            try {
                Integer assetId = Integer.valueOf(req.getParameter("assetId"));
                long timestamp = Long.parseLong(req.getParameter("timestamp"));
                double valor = Double.parseDouble(req.getParameter("valor"));

                Measurement created = ioTService.addMeasurement(assetId, timestamp, valor);

                out.print(HtmlView.successPage("Medicion registrada correctamente con id " + created.getId()
                        + " para el dispositivo " + created.getAssetId() + "."));

            } catch (NumberFormatException e) {
                out.print(HtmlView.alertPage("Parametros invalidos: assetId, timestamp y valor son obligatorios y numericos."));
            } catch (DeviceNotFoundException | OutOfRangeException | DuplicateTimestampException | InvalidIntervalException e) {
                out.print(HtmlView.alertPage(e.getMessage()));
            }
        }
    }
}
