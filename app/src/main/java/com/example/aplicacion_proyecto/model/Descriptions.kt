package com.example.aplicacion_proyecto.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Descriptions(
    @StringRes val stringResourceId: Int,
    @DrawableRes val drawableResourceId: Int,
)