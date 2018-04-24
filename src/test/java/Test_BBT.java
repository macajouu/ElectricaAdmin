import controller.ClientController;
import model.Client;
import org.junit.Test;
import repository.DataManager;

import static org.junit.Assert.assertEquals;


/**
 * Created by Maca on 4/1/2018.
 */
public class Test_BBT
{

    @Test
    public void testCase1()
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
    public void testCase2()
    {
        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController(repo);
        int initialLength = repo.getClients().size();

        try{
            Client c = new Client("", "addr1", "10");
            ctrl.AddClient(c.Name, c.Address, c.idClient);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        assertEquals( initialLength, repo.getClients().size());
    }

    @Test
    public void testCase3()
    {
        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController(repo);
        int initialLength = repo.getClients().size();

        try{
            Client c = new Client("George", "", "19");
            ctrl.AddClient(c.Name, c.Address, c.idClient);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        assertEquals( initialLength, repo.getClients().size());
    }

    @Test
    public void testCase4()
    {
        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController(repo);
        int initialLength = repo.getClients().size();

        try{
            Client c = new Client("George", "addr1", "");
            ctrl.AddClient(c.Name, c.Address, c.idClient);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        assertEquals(initialLength, repo.getClients().size());
    }

    @Test
    public void testCase5()
    {
        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController(repo);
        int initialLength = repo.getClients().size();

        try{
            Client c = new Client("G", "addr1", "29");
            ctrl.AddClient(c.Name, c.Address, c.idClient);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        assertEquals( initialLength, repo.getClients().size());
    }


    @Test
    public void test_addInvoice()
    {
        assert true;
    }

    @Test
    public void test_listInvoices()
    {
        assert true;
    }
}
