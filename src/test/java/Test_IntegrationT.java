import controller.ClientController;
import model.Client;
import org.junit.Test;
import repository.DataManager;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maca on 4/24/2018.
 */
public class Test_IntegrationT
{
    @Test
    public void testCaseA()
    {
        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController(repo);
        int initialLength = repo.getClients().size();

        try{
            Client c = new Client("George", "addr1", "99");
            ctrl.AddClient(c.Name, c.Address, c.idClient);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        assertEquals(initialLength, repo.getClients().size());
    }

    @Test
    public void testCaseB()
    {

        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController(repo);
        int initialLength = repo.getInvoices().size();

        try{
            Client c = repo.getClients().get(0);
            ctrl.AddClientIndex(c, 2025, 7, 50);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        assertEquals( initialLength, repo.getInvoices().size());
    }

    @Test
    public void testCaseC()
    {
        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController(repo);
        int initialLength = repo.getInvoices().size();

        try{
            Client c = repo.getClients().get(0);
            ctrl.ListIssue(c);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        assertEquals( initialLength, repo.getInvoices().size());
    }

    @Test
    public void testCaseBigBang()
    {
        testCaseA();
        testCaseB();
        testCaseC();
    }

    @Test
    public void testCaseAB()
    {
        testCaseA();
        testCaseB();
    }

    @Test
    public void testCaseABC()
    {
        testCaseA();
        testCaseB();
        testCaseC();
    }
}
