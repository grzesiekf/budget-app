import finanses.OutgoList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class Main {

  private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("splitwise");
    public static void main(String[] args) {


       /* OutgoList moja = new OutgoList("moja lista");


        moja.addOutgo("obiad", LocalDate.now(),15.99);
        moja.addOutgo("zakupy",LocalDate.now(), 41.00);
        moja.addOutgo("czekolada",LocalDate.now(), 5.50);

        moja.printOutgoList();

        System.out.println("suma wydatków: "+ moja.outgosSum());

        */

       ENTITY_MANAGER_FACTORY.close();
    }

   public static void addUser(int id, String username, String password)
   {
       EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
       EntityTransaction et = null;
       try{
           et=em.getTransaction();
           et.begin();
           User user = new User();
           user.setUsername(username);
           user.setPassword(password);
           em.persist(user);
           et.commit();
       }
       catch (Exception ex)
       {
           if(et != null)
           {
               et.rollback();
           }
           ex.printStackTrace();
       }
       finally {
           em.close();
       }
   }

}
