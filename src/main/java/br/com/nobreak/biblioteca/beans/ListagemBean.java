package br.com.nobreak.biblioteca.beans;


import br.com.nobreak.biblioteca.report.ConnectionFactory;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import javax.inject.Named;
import javax.swing.*;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;

@Named
public class ListagemBean {

    public void listaTudo() {

        JasperPrint relat = null;
        relat = gerar();
        JasperViewer.viewReport(relat, false);

        /*Connection connection = new ConnectionFactory().getConnection();

        Map<String, Object> params = new HashMap<String, Object>();
        JasperPrint jasperPrint = JasperFillManager.fillReport("/home/moacir/projetos/idea-workspace/Biblioteca/Listagem_de_Titulos_Blank_A4_Landscape.jasper", params, connection);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream("listagem_de_titulos.pdf"));
        exporter.exportReport();

        connection.close();*/
    }

    private JasperPrint gerar() {
        JasperPrint rel = null;
        try {
            Connection con = new ConnectionFactory().getConnection();
            HashMap map = new HashMap();
            String arquivoJasper = "/home/moacir/projetos/idea-workspace/Biblioteca/Listagem_de_Titulos_Blank_A4_Landscape.jasper";
            rel = JasperFillManager.fillReport(arquivoJasper, map, con);
        } catch (Exception e) {
            new JOptionPane().showMessageDialog(null, e);
        }
        return rel;
    }

}

