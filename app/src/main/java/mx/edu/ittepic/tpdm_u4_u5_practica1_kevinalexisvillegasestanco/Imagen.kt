package mx.edu.ittepic.tpdm_u4_u5_practica1_kevinalexisvillegasestanco


import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Imagen(l:Lienzo,posx:Float,posy:Float,id_img:Int) {
    var x = posx
    var y = posy

    var imagen = BitmapFactory.decodeResource(l.resources,id_img)

    fun pintar(c: Canvas){
        c.drawBitmap(imagen,x,y, Paint())


    }

    fun estaEnArea(toquex:Float,toquey:Float):Boolean{
        var x2 = x+imagen.width
        var y2 = y+imagen.height

        if(toquex >= x && toquex <= x2){
            if(toquey >= y && toquey <= y2){
                return true
            }
        }

        return false
    }

    fun mover(xCoor:Float){
        x = x+(xCoor)
    }
}