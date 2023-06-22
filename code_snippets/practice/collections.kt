// task 1 & 2
enum class DayPart {
    MORNING, AFTERNOON, EVENING
}

data class Event (
    val title: String,
    val description: String?,
    val daypart: DayPart,
    val duration: Int
)

fun main() {
    val event = Event("Study Kotlin", "Commit to studying Kotlin at least 15 minutes per day.", DayPart.EVENING, 15)
    println(event)
}

// task 3 
enum class Daypart {
    MORNING, AFTERNOON, EVENING
}

data class Event (
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

fun main() {
    val events = mutableListOf(
        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0),
		Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
		Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
		Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
		Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
		Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
    )
}

// task 4 
enum class Daypart {
    MORNING, AFTERNOON, EVENING
}

data class Event (
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

fun main() {
    val events = mutableListOf(
        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0),
		Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
		Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
		Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
		Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
		Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
    )
    
    val numOfShortEvents = events.filter {
        it.durationInMinutes < 60
    }
    
    println("You have ${numOfShortEvents.size} short events")
}

// task 5
val groupedEvents = events.groupBy {
    it.daypart
}

groupedEvents.forEach { (daypart, events) -> 
    println("$daypart: ${events.size} events")
}

// task 6
println("Last event of the day: ${events[events.size - 1].title}")
println("Last event of the day: ${events.last().title}")

// task 7
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }