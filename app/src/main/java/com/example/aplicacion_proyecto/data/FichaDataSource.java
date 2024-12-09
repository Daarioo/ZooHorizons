package com.example.aplicacion_proyecto.data;

import com.example.aplicacion_proyecto.model.FichaAnimal;

import java.util.ArrayList;
import java.util.List;

public class FichaDataSource {
    private List<FichaAnimal> fichaList;

    public FichaDataSource() {
        fichaList = new ArrayList<>();
    }

    public List<FichaAnimal> getFichaList() {
        return fichaList;
    }

    public void addFicha(FichaAnimal ficha) {
        fichaList.add(ficha);
    }
}