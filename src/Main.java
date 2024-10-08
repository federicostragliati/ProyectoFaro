import dao.implementaciones.RemitoDAO;
import dao.implementaciones.ReportesDAO;

public class Main {
    public static void main(String[] args) {
        RemitoDAO remitoDAO = new RemitoDAO();
        remitoDAO.generarRemito(11);

        ReportesDAO reportesDAO = new ReportesDAO();
        reportesDAO.getChequesAVencer();
    }
}
