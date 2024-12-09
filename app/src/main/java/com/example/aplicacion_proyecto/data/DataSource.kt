package com.example.aplicacion_proyecto.data

import com.example.aplicacion_proyecto.R
import com.example.aplicacion_proyecto.model.Descriptions

class DataSource {
    fun LoadDescription() : List<Descriptions>{
            return listOf<Descriptions>(
                Descriptions(R.string.text1,R.drawable.image1),
                Descriptions(R.string.text2,R.drawable.image2),
                Descriptions(R.string.text3,R.drawable.image3),
                Descriptions(R.string.text4,R.drawable.image4),
                Descriptions(R.string.text5,R.drawable.image5),
                Descriptions(R.string.text6,R.drawable.image6),

            )
    }
}