package jlexdev.com.tareitas;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import jlexdev.com.tareitas.db.TareitaRoomDatabase;
import jlexdev.com.tareitas.db.dao.TareitaDao;
import jlexdev.com.tareitas.db.entity.Tareita;

public class TareitaRepository implements TareitaDao{

    private TareitaDao tareitaDao;
    private LiveData<List<Tareita>> allTareitas;

    public TareitaRepository(Application application) {
        TareitaRoomDatabase db = TareitaRoomDatabase.getDatabase(application);
        tareitaDao = db.tareitaDAO();
        allTareitas = tareitaDao.getAllTareitas();
    }

    @Override
    public void insert(Tareita tareita) {
        new InsertTareitaAsyncTask(tareitaDao).execute(tareita);
    }

    @Override
    public void update(Tareita tareita) {
        new UpdateTareitaAsyncTask(tareitaDao).execute(tareita);
    }

    @Override
    public void delete(Tareita tareita) {
        new DeleteTareitaAsyncTask(tareitaDao).execute(tareita);
    }

    @Override
    public void deleteAllTareitas() {
        new DeleteAllTareitaAsyncTask(tareitaDao).execute();
    }

    @Override
    public LiveData<List<Tareita>> getAllTareitas() {
        return allTareitas;
    }


    // Insert
    private static class InsertTareitaAsyncTask extends AsyncTask<Tareita, Void, Void> {

        private TareitaDao tareitaDao;

        private InsertTareitaAsyncTask(TareitaDao tareitaDao) {
            this.tareitaDao = tareitaDao;
        }

        @Override
        protected Void doInBackground(Tareita... tareitas) {
            tareitaDao.insert(tareitas[0]);
            return null;
        }
    }

    // Update
    private static class UpdateTareitaAsyncTask extends AsyncTask<Tareita, Void, Void> {
        private TareitaDao tareitaDao;

        private UpdateTareitaAsyncTask(TareitaDao tareitaDao) {
            this.tareitaDao = tareitaDao;
        }

        @Override
        protected Void doInBackground(Tareita... tareitas) {
            tareitaDao.update(tareitas[0]);
            return null;
        }
    }

    // Delete
    private static class DeleteTareitaAsyncTask extends AsyncTask<Tareita, Void, Void> {
        private TareitaDao tareitaDao;

        private DeleteTareitaAsyncTask(TareitaDao tareitaDao) {
            this.tareitaDao = tareitaDao;
        }

        @Override
        protected Void doInBackground(Tareita... tareitas) {
            tareitaDao.delete(tareitas[0]);
            return null;
        }
    }

    // DeleteAll
    private static class DeleteAllTareitaAsyncTask extends AsyncTask<Tareita, Void, Void> {
        private TareitaDao tareitaDao;

        private DeleteAllTareitaAsyncTask(TareitaDao tareitaDao) {
            this.tareitaDao = tareitaDao;
        }

        @Override
        protected Void doInBackground(Tareita... tareitas) {
            tareitaDao.deleteAllTareitas();
            return null;
        }
    }
}
