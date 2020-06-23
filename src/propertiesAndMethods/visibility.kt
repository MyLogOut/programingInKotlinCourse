package propertiesAndMethods

import classesContinuation.NotANumber
import org.omg.CORBA.DynAnyPackage.InvalidValue
import java.lang.NumberFormatException
import kotlin.collections.ArrayList

interface Menu {
    fun mainMenu()
    fun updatingMenu()
}

enum class WorkersField {
    Id, Name, Position;

    enum class POSITION {
        CEO, CFO, CIO, COO;

        fun contains(element: String?): Boolean {
            return values().any { it.name == element }
        }
    }
}

data class WorkersWarehouse(private val workers: ArrayList<Worker> = arrayListOf()) {
    fun addWorker(toDatabase: WorkersWarehouse): Boolean {
        val worker = Worker()

        println("Worker inscription form")

        worker.id = when (toDatabase.isEmpty()) {
            true -> {
                0
            }; else -> toDatabase.newId()
        }

        promoteWorker(worker)

        return try {
            workers.add(worker); true
        } catch (exception: Exception) {
            println(exception); false
        }
    }

    fun contains(worker: Worker): Worker? {
        return workers.find { it.id == worker.id }
    }

    fun containsById(id: Int?): Boolean {
        return workers.any { it.id == id ?: println("No matches found") }
    }

    private fun findById(id: Int?): Worker? {
        return workers.find { it.id == id ?: println("No matches found") }
    }

    fun searchById(workerId: Int): Worker? {
        return workers.find { it.id == workerId }
    }

    private fun searchWorker(worker: Worker): Worker? {
        return workers.find { it.id == worker.id }
    }

    fun displayWorkers(): Boolean {
        return if (isEmpty()) {
            println("There are no workers registered to show.")
            false
        } else {
            println("Workers currently registered: ")
            workers.forEach { it.displayInformation() }
            true
        }
    }

    private fun displayMatches(name: String?): Boolean {
        return if (!workers.any { it.name == name }) {
            println("No matches found")
            false
        } else {
            workers.filter { it.name.startsWith(name ?: "", true) }.forEach { it.displayInformation() }
            true
        }
    }

    private fun promoteWorker(worker: Worker): Boolean {
        var positionHolder: String
        var salaryHolder: Double?
        var success: Boolean? = null

        println("Worker's [${WorkersField.valueOf("Name")}]: ")
        do {
            worker.name = readLine().toString()
        } while (worker.name.isEmpty())


        print("Worker's [${WorkersField.Position}: ")
        print(WorkersField.POSITION.values().joinToString(", ", "i.e.: (", ")"))
        println("]:")

        do {
            positionHolder = readLine().toString()
            for (position in WorkersField.POSITION.values()) {
                if (position.contains(positionHolder)) {
                    positionHolder = position.toString()
                    success = true
                } else {
                    success = false
                }
            }
            if (success == false) println("Please type the position as shown above")
        } while (success != true)

        println("Worker's salary: ")
        do {
            salaryHolder = try {
                readLine()?.toDouble() ?: 0.0
            } catch (exception: NumberFormatException) {
                println("$exception - $NotANumber"); 0.0
            }
            if (salaryHolder <= 1.0) {
                println("['$salaryHolder'] Not a valid amount.")
                salaryHolder = 0.0
            }
        } while (salaryHolder == 0.0)

        return try {
            worker.receivingPromotion(positionHolder, salaryHolder!!)
            true
        } catch (exception: Exception) {
            println("$exception - This worker couldn't be successfully promoted/demoted.")
            false
        }
    }

    fun updateWorker(): Boolean {
        var target: Worker? = null

        if (isEmpty()) {
            println("There are no workers registered to update.")
            return false
        }
        displayWorkers()

        do {
            print("Worker currently chosen to be updated: ")
            target?.displayInformation()
            println()
            target = when (navMenu(::findMenuNavContent)) {
                1 -> {
                    print("ID: ")
                    val id = readLine()?.toIntOrNull()
                    //updateProcess(findById(id))
                    findById(id)
                }
                2 -> {
                    println("Name: ")
                    val name = readLine().toString()
                    if (!displayMatches(name)) {
                        null
                    } else {
                        println("\nID: ")
                        //updateProcess(findById(readLine()?.toIntOrNull()))
                        findById(readLine()?.toIntOrNull())
                    }
                }
                3 -> {
                    if (target == null) {
                        println("There must be a targeted worker in order to proceed.")
                        null
                    } else {
                        println("1. Update.\n2. Remove.")
                        when (readLine()?.toIntOrNull()) {
                            1 -> {
                                if (updateWorkerInternalProcess(target) == true) {
                                    println("Worker successfully updated.")
                                    return true
                                } else println("This worker was not updated successfully")
                                null
                            }
                            2 -> {
                                if (dischargeWorker(target)) {
                                    println("Worker successfully discharged.")
                                    return true
                                } else println("This worker was not discharged successfully")
                                null
                            }
                            else -> null
                        }
                    }
                }
                4 -> return target != null
                else -> {
                    println("Not a valid input."); null
                }
            }
        } while (target?.id != null)
        target?.displayInformation()
        println(target)
        return target != null
    }

    private fun updateWorkerInternalProcess(worker: Worker): Boolean? {
        val holder = worker.copy()
        if (isEmpty()) return null
        if (contains(worker) == null) {
            println("ID: ${worker.id}. Name: ${worker.name}. was not found")
            return null
        }
        val updatingWorker = searchWorker(worker)
        updatingWorker?.displayInformation() ?: return false

        println("Choose how you'd like to proceed: ")
        var option: Boolean?
        do {
            option = when (navMenu(::updateMenuNavContent)) {
                1 -> {
                    print("Current name: ${updatingWorker.name}.\nNew name: ")
                    try {
                        updatingWorker.name = readLine().toString(); true
                    } catch (exception: InvalidValue) {
                        println("$exception - Not a valid value."); false
                    }
                }
                2, 3 -> {
                    promoteWorker(updatingWorker)
                }
                4 -> {
                    dischargeWorker(updatingWorker)
                }
                5 -> {
                    false
                }
                else -> {
                    null
                }
            }
        } while (option == null)
        println("Previous worker ${holder.name}: ")
        holder.displayInformation()
        println("\nUpdated worker ${updatingWorker.name}: ")
        updatingWorker.displayInformation()
        return option
    }
    /*private fun updateProcess(worker: Worker?): Worker? {

        return worker
    }*/
    private fun dischargeWorker(worker: Worker): Boolean {
        return workers.remove(worker)
    }

    private fun isEmpty() = workers.isEmpty()
    fun last() = workers.last().id
    private fun newId() = workers.last().id ?: 0 + 1
}

class Worker {
    //var name has Public visibility by default in Kotlin, which means it can be used in the whole project.
    var name: String = ""

    //var id has Internal visibility in kotlin, which means it can be used inside this package.
    internal var id: Int? = null

    //var position has Private visibility in Kotlin, which means it can be used only in this scope [Class]
    // and not by inheritance.
    private var position = String()
    private var annualSalary: Double = 0.0

    fun displayInformation() {
        println("$id. $name: Position: $position with an annual salary of $annualSalary")
    }
    fun receivingPromotion(newPosition: String, annualSalary: Double): Boolean? {
        return try {
            position = newPosition
            this.annualSalary = annualSalary
            true
        } catch (exception: Exception ) { println("Error: ${exception.message}. Failed to promote worker [${this.name}]."); null }
    }
    fun copy(): Worker {
        val copied = Worker()
        copied.id = this.id
        copied.name = this.name
        copied.position = this.position
        copied.annualSalary = this.annualSalary
        return copied
    }
}

fun main() {
    val workersRunningData = WorkersWarehouse()
    do {
        val option = navMenu { mainMenuNavContent() }
        try {
            when (option) {
                1 -> { workersRunningData.addWorker(workersRunningData) }
                2 -> { workersRunningData.displayWorkers() }
                3 -> { workersRunningData.updateWorker() }
                4 -> { println("Exiting"); return }
                else -> { println("Not a valid option") }
            }
        } catch (exception: NumberFormatException) { println("$exception - $NotANumber") }
    } while (option != null)
    //workersRunningData.addWorker(workersRunningData)
}

fun navMenu(menu: () -> Unit): Int? {
    println("Workers Management Tool [WMT]")
    println("Please choose how you'd like to proceed")
    menu()

    return try {
        when (readLine()?.toInt()) {
            1 -> 1
            2 -> 2
            3 -> 3
            4 -> 4
            else -> {
                println("Not a valid option.")
                0
            }
        }
    } catch (exception: NumberFormatException) { println("$exception - $NotANumber"); 0 }
}

fun mainMenuNavContent()  {
    println("1. Add Worker")
    println("2. Display existing workers")
    println("3. Update or safely remove an existing worker")
    println("4. Exit.")
}
fun findMenuNavContent() {
    println("1. I got an ID and I want to choose this worker with it.")
    println("2. I don't have any ID but I do have a name.")
    println("3. Update or safely remove an existing worker")
    println("4. Return")
}
fun updateMenuNavContent() {
    println("1. Name.")
    println("2. Promote.")
    println("3. Demote.")
    println("4. Remove.")
    println("5. Return.")
}
