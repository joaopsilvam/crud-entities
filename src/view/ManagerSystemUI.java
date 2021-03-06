package view;

import business.control.Facade;
import business.control.command.Executor;
import util.InfraException;

import javax.swing.*;

public class ManagerSystemUI implements IForms{

    Facade facade;
    Executor executor;
    public ManagerSystemUI(Facade facade, Executor executor)  {
        this.facade = facade;
        this.executor = executor;
    }

    public boolean menu(){
        String operation = JOptionPane.showInputDialog("Com o quê você deseja trabalhar?" +
                "\n[a] Usuários\n[b] Eventos\n[c] Documentos\n[d] Relatórios\n[e] Notícias\n[x] Sair");

        if(operation == null){
            operation = "x";
        }

        switch (operation) {
            case "a":
                sectionUsers();
                break;
            case "b":
                sectionEvents();
                break;
            case "c":
                sectionDocuments();
                break;
            case "d":
                sectionReports();
                break;
            case "e":
                sectionNews();
                break;
            case "x":
                return false;
            default:
                JOptionPane.showMessageDialog(null, "Informe uma operação válida");
                break;
        }
        return true;
    }

    private void sectionUsers() {
        new UserUI(this.facade, this.executor).menu();
    }
    private void sectionEvents() {
        new EventUI(this.facade, this.executor).menu();
    }
    private void sectionNews() {
        new NewsUI(this.facade, this.executor).menu();
    }
    private void sectionDocuments() {
        new DocumentUI(this.facade, this.executor).menu();
    }
    private void sectionReports() {
        try {
            new ReportUI(this.facade).menu();
        } catch (InfraException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
