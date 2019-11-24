package mx.edu.ittepic.tpdm_u4_u5_practica1_kevinalexisvillegasestanco

import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import java.util.ArrayList


class Lienzo(p:MainActivity): View(p) {
    var puntero = p

    var icono1 = Imagen(this, 250f, 50f, R.drawable.facebook)
    var icono2 = Imagen(this, 250f, 200f, R.drawable.instagram)
    var icono3 = Imagen(this, 250f, 350f, R.drawable.twitter)
    var icono4 = Imagen(this, 250f, 500f, R.drawable.whatsapp)
    var icono5 = Imagen(this, 250f, 650f, R.drawable.youtube)

    var icono1_2 = Imagen(this, 250f, 50f, R.drawable.facebookblack)
    var icono2_2 = Imagen(this, 250f, 200f, R.drawable.instagramblack)
    var icono3_2 = Imagen(this, 250f, 350f, R.drawable.twitterblack)
    var icono4_2 = Imagen(this, 250f, 500f, R.drawable.whatsappblack)
    var icono5_2= Imagen(this, 250f, 650f, R.drawable.youtubeblack)

    var icono1_3= Imagen(this, 250f, 50f, R.drawable.facebookvintage)
    var icono2_3 = Imagen(this, 250f, 200f, R.drawable.instagramvintage)
    var icono3_3 = Imagen(this, 250f, 350f, R.drawable.twittervintage)
    var icono4_3 = Imagen(this, 250f, 500f, R.drawable.whatsappvintage)
    var icono5_3 = Imagen(this, 250f, 650f, R.drawable.youtubevintage)

    var icono1_4 = Imagen(this, 250f, 50f, R.drawable.facebook)
    var icono2_4 = Imagen(this, 250f, 200f, R.drawable.instagram)
    var icono3_4 = Imagen(this, 250f, 350f, R.drawable.twitter)
    var icono4_4 = Imagen(this, 250f, 500f, R.drawable.whatsapp)
    var icono5_4 = Imagen(this, 250f, 650f, R.drawable.youtube)

    var arrayImg = arrayListOf<Imagen>(icono1,icono2,icono3,icono4,icono5)
    var arrayImg2 = arrayListOf<Imagen>(icono1_2,icono2_2,icono3_2,icono4_2,icono5_2)
    var arrayImg3 = arrayListOf<Imagen>(icono1_3,icono2_3,icono3_3,icono4_3,icono5_3)
    var arrayImg4 = arrayListOf<Imagen>(icono1_4,icono2_4,icono3_4,icono4_4,icono5_4)
    var picono: Imagen ?= null

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()

        if(puntero.distancia == 0f){
            Toast.makeText(puntero,"Oculto", Toast.LENGTH_SHORT).show()
        }
        else{
            when (puntero.countShake) {
                0 -> {
                    drawImgs(arrayImg, c)
                    moverImagenes(arrayImg, puntero.x)
                }
                1 -> {
                    drawImgs(arrayImg2, c)
                    moverImagenes(arrayImg2, puntero.x)
                }
                2 -> {
                    drawImgs(arrayImg3, c)
                    moverImagenes(arrayImg3, puntero.x)
                }
                3 -> {
                    drawImgs(arrayImg4, c)
                    moverImagenes(arrayImg4, puntero.x)
                }
            }

        }

    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        when(e.action){

            MotionEvent.ACTION_DOWN -> {
                if(icono1.estaEnArea(e.getX(),e.getY())||
                    icono1_2.estaEnArea(e.getX(),e.getY())||
                    icono1_3.estaEnArea(e.getX(),e.getY())||
                    icono1_4.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste icono Facebook", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono1

                }
                if(icono2.estaEnArea(e.getX(),e.getY())||
                    icono2_2.estaEnArea(e.getX(),e.getY())||
                    icono2_3.estaEnArea(e.getX(),e.getY())||
                    icono2_4.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste icono Instagram", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono2
                }
                if(icono3.estaEnArea(e.getX(),e.getY())||
                    icono3_2.estaEnArea(e.getX(),e.getY())||
                    icono3_3.estaEnArea(e.getX(),e.getY())||
                    icono3_4.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste icono Twitter", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono3
                }
                if(icono4.estaEnArea(e.getX(),e.getY())||
                    icono4_2.estaEnArea(e.getX(),e.getY())||
                    icono4_3.estaEnArea(e.getX(),e.getY())||
                    icono4_4.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste icono Whatsapp", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono4
                }
                if(icono5.estaEnArea(e.getX(),e.getY())||
                    icono5_2.estaEnArea(e.getX(),e.getY())||
                    icono5_3.estaEnArea(e.getX(),e.getY())||
                    icono5_4.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste icono YouTube", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono5
                }
            }
            MotionEvent.ACTION_MOVE -> {

            }
            MotionEvent.ACTION_UP -> {
                picono = null
            }

        }
        return true
    }

    fun moverImagenes(arrayImagenes: ArrayList<Imagen>, x:Float){
        arrayImagenes.forEach {
            it.mover(x)
        }
        invalidate()
    }

    fun hideImages(c: Canvas){
        c.restore()
        invalidate()
    }

    fun drawImgs(arrayImagenes: ArrayList<Imagen>, c: Canvas) {
        arrayImagenes.forEach {
            it.pintar(c)

        }
    }
}
