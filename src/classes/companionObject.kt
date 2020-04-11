package classes

import java.time.Year

data class Vehicle(val brand: String = String(),
                   val model: Year = Year.parse("2000"),
                   var speed: Double = 100.0)
class VehicleWarehouse private constructor() {
    companion object VehicleLoader {
        private val warehouse: ArrayList<Vehicle> = arrayListOf()
        fun storeVehicle(brand: String, model: Year, speed: Double) {
            val triple: Triple<String, Year, Double>? = Triple(brand, model, speed)
             if (triple != null) warehouse.add(Vehicle(brand = brand, model = model, speed = speed))
            else println("You must provide the whole Vehicle data in order to store it on this Vehicle warehouse")
        }
        fun display() {
            println("Warehouse vehicles:")
            warehouse.forEach(::println)
        }
    }
}

fun main() {
    var newCar = Triple("Mitsubishi", Year.parse("1997"), 110.0)
    val vehicleWarehouse = VehicleWarehouse
    vehicleWarehouse.storeVehicle(newCar.first, newCar.second, newCar.third)
    newCar = Triple("Mitsubishi", Year.parse("2020"), 210.0)
    vehicleWarehouse.storeVehicle(newCar.first, newCar.second, newCar.third)
    vehicleWarehouse.display()
}