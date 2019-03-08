package atlassianmobilefinder.com.store

import java.util.*

const val LOCAL_ID = "localId"

interface PositionsFactory {
    fun newPosition() = System.nanoTime()
}

enum class Color1 {
    RED, YELLOW, GREEN, BLUE, WHITE
}

data class Item(
    val localId: String = generateLocalId(),
    val text: String? = null,
    val favorite: Boolean = false,
    val color: Color1 = Color1.WHITE,
    val position: Long = object : PositionsFactory {}.newPosition()
) {

    fun isEmpty(): Boolean = text == null

    fun isNotEmpty(): Boolean = !isEmpty()

}

fun generateLocalId(): String = LOCAL_ID + "_" + UUID.randomUUID().toString().replace("-".toRegex(), "")