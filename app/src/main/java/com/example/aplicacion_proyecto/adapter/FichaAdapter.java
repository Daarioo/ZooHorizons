package com.example.aplicacion_proyecto.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacion_proyecto.R;
import com.example.aplicacion_proyecto.model.FichaAnimal;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FichaAdapter extends RecyclerView.Adapter<FichaAdapter.FichaViewHolder> {

    private Context context;
    private List<FichaAnimal> fichaList;

    public FichaAdapter(Context context, List<FichaAnimal> fichaList) {
        this.context = context;
        this.fichaList = fichaList;
    }

    @NonNull
    @Override
    public FichaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_petlist, parent, false); // Cambié item_petlist a item_ficha
        return new FichaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FichaViewHolder holder, int position) {
        FichaAnimal ficha = fichaList.get(position);
        holder.nombreTextView.setText(ficha.getNombre());
        holder.tipoAnimalTextView.setText(ficha.getTipoAnimal());
        holder.fechaAdopcionTextView.setText(ficha.getFechaAdopcion());

        Log.d("FichaAdapter", "Elemento enlazado: " + ficha.getNombre());

        holder.btnEditPet.setOnClickListener(v -> {
            Toast.makeText(context, "Editar ficha: " + ficha.getNombre(), Toast.LENGTH_SHORT).show();
        });

        holder.btnDeletePet.setOnClickListener(v -> {
            fichaList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, fichaList.size());
            Toast.makeText(context, "Ficha eliminada: " + ficha.getNombre(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return fichaList.size();
    }

    public void agregarFicha(FichaAnimal ficha) {
        fichaList.add(ficha);
        notifyItemInserted(fichaList.size() - 1);
    }

    public static class FichaViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView;
        TextView tipoAnimalTextView;
        TextView fechaAdopcionTextView;
        Button btnEditPet;
        Button btnDeletePet;

        public FichaViewHolder(View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.tvName); // Cambié a los IDs correctos
            tipoAnimalTextView = itemView.findViewById(R.id.tvType);
            fechaAdopcionTextView = itemView.findViewById(R.id.tvDate);
            btnEditPet = itemView.findViewById(R.id.btnEditPet);
            btnDeletePet = itemView.findViewById(R.id.btnDeletePet);
        }
    }
}