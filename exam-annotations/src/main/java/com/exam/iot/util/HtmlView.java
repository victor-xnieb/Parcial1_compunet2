package com.exam.iot.util;

import com.exam.iot.model.Measurement;

import java.util.List;

/**
 * Genera las "vistas" en HTML que exige el enunciado (alertas y listado).
 * No se usa JSP a proposito: se construye el HTML directamente para que el
 * despliegue en Tomcat no dependa de tener JSTL u otras librerias extra.
 */
public final class HtmlView {

    private HtmlView() {}

    public static String page(String title, String bodyHtml) {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"es\">\n" +
                "<head><meta charset=\"UTF-8\"><title>" + escape(title) + "</title>" +
                "<style>" +
                "body{font-family:Arial,Helvetica,sans-serif;margin:40px;background:#f4f4f4;}" +
                ".alert{background:#ffe1e1;border:1px solid #d9534f;color:#a94442;padding:16px;border-radius:6px;}" +
                ".ok{background:#e2f7e1;border:1px solid #4caf50;color:#256029;padding:16px;border-radius:6px;}" +
                "table{border-collapse:collapse;width:100%;background:#fff;}" +
                "th,td{border:1px solid #ccc;padding:8px 12px;text-align:left;}" +
                "th{background:#333;color:#fff;}" +
                "a{color:#337ab7;}" +
                "</style></head><body>" +
                "<h1>" + escape(title) + "</h1>" +
                bodyHtml +
                "<p><a href=\"list-measurements\">Ver todas las mediciones</a> | " +
                "<a href=\"add-form\">Agregar medicion</a></p>" +
                "</body></html>";
    }

    public static String alertPage(String message) {
        String body = "<div class=\"alert\"><strong>Alerta:</strong> " + escape(message) + "</div>";
        return page("No fue posible registrar la medicion", body);
    }

    public static String successPage(String message) {
        String body = "<div class=\"ok\">" + escape(message) + "</div>";
        return page("Medicion registrada", body);
    }

    public static String measurementsTable(List<Measurement> measurements) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table><tr><th>ID</th><th>Timestamp</th><th>Valor</th><th>Asset ID</th></tr>");
        for (Measurement m : measurements) {
            sb.append("<tr><td>").append(m.getId())
              .append("</td><td>").append(m.getTimestamp())
              .append("</td><td>").append(m.getValor())
              .append("</td><td>").append(m.getAssetId())
              .append("</td></tr>");
        }
        sb.append("</table>");
        return page("Listado de mediciones", sb.toString());
    }

    public static String addForm() {
        String body = "<form method=\"post\" action=\"add-measurement\">" +
                "<p>Asset ID: <input type=\"number\" name=\"assetId\" required></p>" +
                "<p>Timestamp (ms): <input type=\"number\" name=\"timestamp\" required></p>" +
                "<p>Valor: <input type=\"number\" step=\"any\" name=\"valor\" required></p>" +
                "<button type=\"submit\">Registrar</button>" +
                "</form>";
        return page("Agregar medicion", body);
    }

    private static String escape(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
