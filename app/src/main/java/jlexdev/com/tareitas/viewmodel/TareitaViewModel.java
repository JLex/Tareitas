package jlexdev.com.tareitas.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import jlexdev.com.tareitas.TareitaRepository;
import jlexdev.com.tareitas.db.dao.TareitaDao;
import jlexdev.com.tareitas.db.entity.Tareita;

public class TareitaViewModel extends AndroidViewModel implements TareitaDao {

    private TareitaRepository repository;
    private LiveData<List<Tareita>> allTareitas;

    public TareitaViewModel(Application application) {
        super(application);

        repository = new TareitaRepository(application);
        allTareitas = repository.getAllTareitas();
    }

    @Override
    public void insert(Tareita tareita) {
        repository.insert(tareita);
    }

    @Override
    public void update(Tareita tareita) {
        repository.insert(tareita);
    }

    @Override
    public void delete(Tareita tareita) {
        repository.insert(tareita);
    }

    @Override
    public void deleteAllTareitas() {
        repository.deleteAllTareitas();
    }

    @Override
    public LiveData<List<Tareita>> getAllTareitas() {
        return allTareitas;
    }


}
