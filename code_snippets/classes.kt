class SmartTvDevice(name: String, category: String) : 
    SmartDevice(name, category)
{
    override val deviceType = "Smart TV"
    
    var speakerVolume = 2
        set(value) {
            if(value in 1..100) {
                field = value
            }
        }
        
    var channelValue = 1
        set(value) {
            if(value in 1..200) {
                field = value
            }
        }
        
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
    
    fun nextChannel() {
        channelValue++
        println("Channel number increased to $channelValue")
    }
}

class SmartLightDevice(name: String, category: String) : 
    SmartDevice(name, category) {
    
    override val deviceType = "Smart Light"
    
    var brightnessLevel = 0
        set(value) {
            if(value in 1..100) {
                field = value
            }
        }
    
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
    fun turnOnTv() {
        smartTvDevice.turnOn()
    }
    
    fun turnOffTv() {
        smartTvDevice.turnOff()
    }
    
    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }
    
    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
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

fun main() {
   var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment");
   println(smartDevice.deviceType)
   smartDevice = SmartLightDevice("Google Light", "Utility")
   println(smartDevice.deviceType)
}