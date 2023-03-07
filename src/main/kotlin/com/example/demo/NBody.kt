package com.example.demo

class NBody {
    private var bodies: Array<Body> = emptyArray()

    fun NBodySystem() {
        bodies = arrayOf(
                Body.sun(),
                Body.jupiter(),
                Body.saturn(),
                Body.uranus(),
                Body.neptune()
        )
        var px = 0.0
        var py = 0.0
        var pz = 0.0
        for (i in bodies.indices) {
            px += bodies[i].vx * bodies[i].mass
            py += bodies[i].vy * bodies[i].mass
            pz += bodies[i].vz * bodies[i].mass
        }
        bodies[0].offsetMomentum(px, py, pz)
    }

    fun advance(dt: Double) {
        for (i in bodies.indices) {
            val iBody = bodies[i]
            for (j in i + 1 until bodies.size) {
                val dx = iBody.x - bodies[j].x
                val dy = iBody.y - bodies[j].y
                val dz = iBody.z - bodies[j].z
                val dSquared = dx * dx + dy * dy + dz * dz
                val distance = Math.sqrt(dSquared)
                val mag = dt / (dSquared * distance)
                iBody.vx -= dx * bodies[j].mass * mag
                iBody.vy -= dy * bodies[j].mass * mag
                iBody.vz -= dz * bodies[j].mass * mag
                bodies[j].vx += dx * iBody.mass * mag
                bodies[j].vy += dy * iBody.mass * mag
                bodies[j].vz += dz * iBody.mass * mag
            }
        }
        for (body in bodies) {
            body.x += dt * body.vx
            body.y += dt * body.vy
            body.z += dt * body.vz
        }
    }

    fun energy(): Double {
        var dx: Double
        var dy: Double
        var dz: Double
        var distance: Double
        var e = 0.0
        for (i in bodies.indices) {
            val iBody = bodies[i]
            e += 0.5 * iBody.mass * (iBody.vx * iBody.vx + iBody.vy * iBody.vy + iBody.vz * iBody.vz)
            for (j in i + 1 until bodies.size) {
                val jBody = bodies[j]
                dx = iBody.x - jBody.x
                dy = iBody.y - jBody.y
                dz = iBody.z - jBody.z
                distance = Math.sqrt(dx * dx + dy * dy + dz * dz)
                e -= iBody.mass * jBody.mass / distance
            }
        }
        return e
    }
}