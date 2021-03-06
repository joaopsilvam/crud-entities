package business.control.factories;

import business.control.UserStatisticControl;
import business.control.reportmanagers.ReportManagerBase;

import java.util.HashMap;

public class ReportManagerFactory {
    public HashMap<String, IReportManagerFactory> reportManagerFactories = new HashMap<String, IReportManagerFactory>();

    private static ReportManagerFactory instancia;

    public ReportManagerFactory() {
      this.reportManagerFactories.put("pdf", new ReportManagerPdfFactory());
      this.reportManagerFactories.put("html", new ReportManagerHtmlFactory());
      this.reportManagerFactories.put("txt", new ReportManagerTxtFactory());
    }

    public static ReportManagerFactory getInstancia() {
        if (instancia == null)
            instancia = new ReportManagerFactory();
        return instancia;
    }

    public ReportManagerBase create(String typeReport , UserStatisticControl userStatisticControl){
      IReportManagerFactory factory = this.reportManagerFactories.get(typeReport);

      return factory.create(userStatisticControl);
    }  
}