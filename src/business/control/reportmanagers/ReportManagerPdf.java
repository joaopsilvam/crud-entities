package business.control.reportmanagers;

import business.model.UserStatistic;

import java.util.List;

public class ReportManagerPdf extends ReportManagerBase{

    @Override
    protected List<UserStatistic> loadFile() {
        return null;
    }

    @Override
    protected void saveFile(List<UserStatistic> statistics) {

    }
}
