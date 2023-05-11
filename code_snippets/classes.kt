import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SmartTvDevice(name: String, category: String) : 
    SmartDevice(name, category)
{
    override val deviceType = "Smart TV"
    
    private var speakerVolume by RangeRegulator(0, 0, 100)
    private var channelValue by RangeRegulator(1, 0, 200)
        
    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                "set to $channelValue."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
        
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume")
    }
    
    internal fun nextChannel() {
        channelValue++
        println("Channel number increased to $channelValue")
    }
}

class SmartLightDevice(name: String, category: String) : 
    SmartDevice(name, category) {
    
    override val deviceType = "Smart Light"
    
    private var brightnessLevel by RangeRegulator(2, 0, 100)
    
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }
    
    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
    
    fun increaseBrightnessLevel() {
        brightnessLevel++
        println("Brightness level increased to $brightnessLevel")
    }
}
open class SmartDevice constructor(val name: String, val category: String) {
    var deviceStatus = "online"
    	protected set
    
    open val deviceType = "unknown"
    
    constructor(name: String, category: String, statusCode: Int): this(name, category) {
        deviceStatus = when(statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }
    
    open fun turnOn() {
        deviceStatus = "on"
    }
    
    open fun turnOff() {
        deviceStatus = "off"
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    var deviceTurnOnCount = 0
        private set
    
    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }
    
    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }
    
    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }
    
    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }
    
    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightnessLevel()
    }
    
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(
    initialValue: Int, 
    private val minValue: Int, 
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {
    
    var fieldData = initialValue
    
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }
    
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if(value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
   var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment");
   println(smartDevice.deviceType)
   smartDevice = SmartLightDevice("Google Light", "Utility")
   println(smartDevice.deviceType)
}