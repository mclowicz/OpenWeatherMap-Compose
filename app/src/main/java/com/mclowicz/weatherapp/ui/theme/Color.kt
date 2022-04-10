package com.mclowicz.weatherapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val LightBg = Color(0xFFFFFBDB)
val Ebony = Color(0xFF5F634F)
val LightBLue = Color(0xFF9BC4CB)
val HoneyDew = Color(0xFFCFEBDF)
val Violet = Color(0xFF7776BC)
val Languid = Color(0xFFf2e6ff)
val HalfBlack = Color(0xB55F634F).compositeOver(Color(0x00FFFFFF))

val Colors.topAppBarContentColor: Color
    get() = if (isLight) Color.White else Color.White

val Colors.topAppBarBackgroundColor: Color
    get() = if (isLight) Purple700 else Color.Black