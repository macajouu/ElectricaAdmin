import controller.ClientController;
import model.Client;
import org.junit.Test;
import repository.DataManager;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maca on 4/3/2018.
 */
public class Test_WBT
{
    @Test
    public void testCase1()
    {

        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController(repo);
        int initialLength = repo.getInvoices().size();

        try{
            Client c = repo.getClients().get(0);
            ctrl.AddClientIndex(c, 2029, 7, 50);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        assertEquals( initialLength, repo.getInvoices().size());
    }

    @Test
    public void testCase2()
    {

        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController(repo);
        int initialLength = repo.getInvoices().size();

        try{
            Client c = repo.getClients().get(0);
            ctrl.AddClientIndex(c, 0, 4, 25);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        assertEquals( initialLength, repo.getInvoices().size());
    }

    @Test
    public void testCase3()
    {

        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController(repo);
        int initialLength = repo.getInvoices().size();

        try{
            Client c = repo.getClients().get(0);
            ctrl.AddClientIndex(c, 2018, 0, 25);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        assertEquals( initialLength, repo.getInvoices().size());
    }

    @Test
    public void testCase4()
    {

        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController(repo);
        int initialLength = repo.getInvoices().size();

        try{
            Client c = repo.getClients().get(0);
            ctrl.AddClientIndex(c, 2018, 4, -15);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        assertEquals( initialLength, repo.getInvoices().size());
    }

    @Test
    public void testCase5()
    {

        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController(repo);
        int initialLength = repo.getInvoices().size();

        try{
            Client c = new Client("", "", "");
            ctrl.AddClientIndex(c, 2018, 4, 25);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        assertEquals( initialLength, repo.getInvoices().size());
    }

    @Test
    public void testCase6()
    {

        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController(repo);
        int initialLength = repo.getInvoices().size();

        try{
            Client c = new Client("asd", "fdsasd", "23");
            ctrl.AddClientIndex(c, 2018, 4, 25);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        assertEquals( initialLength, repo.getInvoices().size());
    }

    @Test
    public void testCase7()
    {

        DataManager repo = new DataManager();
        ClientController ctrl = new ClientController(repo);
        int initialLength = repo.getInvoices().size();

        try{
            Client c = repo.getClients().get(0);
            ctrl.AddClientIndex(c, 2019, 7, 50);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        assertEquals( initialLength, repo.getInvoices().size());
    }

}
