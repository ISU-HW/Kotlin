enum class Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

class Robot(var x: Int, var y: Int, var direction: Direction) {
    fun stepForward() {
        when (direction) {
            Direction.RIGHT -> x++
            Direction.LEFT -> x--
            Direction.UP -> y++
            Direction.DOWN -> y--
        }
    }

    fun turnLeft() {
        when (direction) {
            Direction.RIGHT -> direction = Direction.UP
            Direction.LEFT -> direction = Direction.DOWN
            Direction.UP -> direction = Direction.LEFT
            Direction.DOWN -> direction = Direction.RIGHT
        }
    }

    fun turnRight() {
        when (direction) {
            Direction.RIGHT -> direction = Direction.DOWN
            Direction.LEFT -> direction = Direction.UP
            Direction.UP -> direction = Direction.RIGHT
            Direction.DOWN -> direction = Direction.LEFT
        }
    }

    override fun toString(): String {
        return "(${x}, ${y}), looks ${direction}"
    }
}
