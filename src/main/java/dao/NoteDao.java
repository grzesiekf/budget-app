package dao;

import model.Note;


public class NoteDao extends AbstractDao<Note> {

    private static volatile NoteDao instance;

    public static NoteDao getInstance() {
        if(instance == null) {
            synchronized(NoteDao.class) {
                if (instance == null) {
                    instance = new NoteDao();
                }
            }
        }
        return instance;
    }

    private NoteDao() {
        super(Note.class);
    }

    @Override
    public Note newInstance() {
        return super.newInstance(new Note());
    }
}
