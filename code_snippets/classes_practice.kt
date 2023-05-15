// 1. mobile notifications ✅

fun main() {
    val morningNotification = 51
    val eveningNotification = 135
    
    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}


fun printNotificationSummary(numberOfMessages: Int) {
    if(numberOfMessages < 100) println("You have $numberOfMessages notifications.")
    else println("Your phone is blowing up! You have 99+ notifications.")
}

// 2. movie ticket price ✅
fun main() {
    val child = 5
    val adult = 28
    val senior = 87
    
    val isMonday = true
    
    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    val result = when(age) {
        in 0..12 -> 15
        in 13..60 -> if(isMonday) 25 else 30
        in 61..100 -> 20
        else -> -1
    }
    
    return result
}

// 3. temperature converter ✅
fun main() {
    val convertKelvinToCelsis: (Double) -> Double = { it - 273.15 }
    val convertFahrenheitToKelvin: (Double) -> Double = {
        ((it - 32) * 5) / 9 + 273.15
    }
    
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { (9 * it) / 5 + 32}
    printFinalTemperature(350.0, "Kelvin", "Celsius", convertKelvinToCelsis)
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin", convertFahrenheitToKelvin)
}

fun printFinalTemperature(
    initialMeasurement: Double, 
    initialUnit: String, 
    finalUnit: String, 
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

// 4. song catalog

fun main() {
    val song = Song(
    	"Oops! I did it again",
        "Britney Spears",
        2002,
	)
    
    song.printDetails()
    song.playCount = 4
    println(song.popular)
    
}

// pass the constructor parameters with val and you won't need to initialise the variables on line 80 - 82
class Song(title: String, artist: String, yearPublished: Int) {
    val title = title
    val artist = artist
    val yearPublished = yearPublished
    
    var playCount = 0
    	set(value) {
            field = value
            if(value > 1000) {
                popular = true
            } else {
                popular = false
            }
        }
    
    var popular = false
        
    fun printDetails() {
        println(
        	"$title, performed by $artist, was released in $yearPublished."
        )
    }
}

// 5. Internet Profile

fun main() {    
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    
    amanda.showProfile()
    atiqah.showProfile()
}


class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
       println("Name: $name")
       println("Age: $age")
       println("Likes to $hobby. ${getReferrerInfo(referrer)}")
    }
    
    fun getReferrerInfo(referrer: Person?): String {
        if(referrer == null) {
            return "Doesn't have a referrer."
        } else {
            val referrerName = referrer.name
            var referrerHobby = referrer.hobby
            return "Has a referrer named $referrerName, who likes to $referrerHobby."
        }
        
    }
}


// 6. foldable phone

open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(isScreenLightOn: Boolean = false) : Phone(isScreenLightOn) {
    private var isPhoneFolded = false
        
    override fun switchOn() {
        if(isPhoneFolded == true) {
            isScreenLightOn = true
        }
    }
    
    fun foldPhone() {
        isPhoneFolded = false
    }
    
    fun openPhone() {
        isPhoneFolded = true
    }
}

fun main() {
    val phone: FoldablePhone = FoldablePhone(false);
    phone.openPhone()
    phone.switchOn()
    phone.checkPhoneScreenLight()
}

// 7. special auction

fun main() {
    val winningBid = Bid(5000, "Private Collector")
    
    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)
 
fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    return bid?.amount ?: minimumPrice
}