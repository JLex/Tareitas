package jlexdev.com.tareitas.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jlexdev.com.tareitas.R;
import jlexdev.com.tareitas.db.entity.Tareita;

public class TareitaAdapter extends RecyclerView.Adapter<TareitaAdapter.TareitaViewHolder> {

    private List<Tareita> tareitas;
    private final LayoutInflater inflater;

    public TareitaAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TareitaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = inflater.inflate(R.layout.recyclerview_item, viewGroup, false);

        return new TareitaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TareitaViewHolder tareitaHolder, int i) {
        if (tareitas != null) {
            Tareita currentTareita = tareitas.get(i);

            tareitaHolder.tvTitle.setText(currentTareita.getTitle());
            tareitaHolder.tvDescription.setText(currentTareita.getDescription());
        } else {
            tareitaHolder.tvTitle.setText("No Tareita");
        }

    }

    @Override
    public int getItemCount() {
        if (tareitas != null)
            return tareitas.size();
        else return 0;
    }

    // Notificar cambios
    public void setTareitas(List<Tareita> tareitas) {
        this.tareitas = tareitas;
        notifyDataSetChanged();
    }


    // ViewHolder
    class TareitaViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle;
        private final TextView tvDescription;

        private TareitaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }
    }

}
