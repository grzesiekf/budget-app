package dao;

import model.Outgo;


public class OutgoDao extends AbstractDao<Outgo> {

    private static volatile OutgoDao instance;

    public static OutgoDao getInstance() {
        if(instance == null) {
            synchronized(OutgoDao.class) {
                if (instance == null) {
                    instance = new OutgoDao();
                }
            }
        }
        return instance;
    }

    private OutgoDao() {
        super(Outgo.class);
    }

}
