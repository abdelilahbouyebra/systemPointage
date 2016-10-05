package com.pointage.Metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class TestReport{

  Connection con;
  public void generateReport() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BioStar","root", "");
      System.out.println("Filling report...");
      JasperReport jasperReport=(JasperReport) JRLoader.loadObject(TestReport.class.getResource("/resources/report/test.jasper"));
      JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,new HashMap<String, Object> (), con);
      JasperExportManager.exportReportToPdfFile(jasperPrint,"c:/temp/test.pdf");
      System.out.println("Done!");
      con.close();
    } catch (JRException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new TestReport().generateReport();
  }

}