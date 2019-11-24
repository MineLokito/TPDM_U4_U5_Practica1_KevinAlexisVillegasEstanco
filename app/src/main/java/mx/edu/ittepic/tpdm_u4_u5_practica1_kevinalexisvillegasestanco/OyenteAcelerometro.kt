package mx.edu.ittepic.tpdm_u4_u5_practica1_kevinalexisvillegasestanco

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class OyenteAcelerometro (p:MainActivity): SensorEventListener {
    var puntero = p
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        puntero.x = event!!.values[0]
    }

}