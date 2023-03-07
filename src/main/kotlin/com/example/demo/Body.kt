package com.example.demo

internal class Body {
    var x = 0.0
    var y = 0.0
    var z = 0.0
    var vx = 0.0
    var vy = 0.0
    var vz = 0.0
    var mass = 0.0
    fun offsetMomentum(px: Double, py: Double, pz: Double): Body {
        vx = -px / SOLAR_MASS
        vy = -py / SOLAR_MASS
        vz = -pz / SOLAR_MASS
        return this
    }

    companion object {
        const val PI = 3.141592653589793
        const val SOLAR_MASS = 4 * PI * PI
        const val DAYS_PER_YEAR = 365.24
        fun jupiter(): Body {
            val p = Body()
            p.x = 4.84143144246472090e+00
            p.y = -1.16032004402742839e+00
            p.z = -1.03622044471123109e-01
            p.vx = 1.66007664274403694e-03 * DAYS_PER_YEAR
            p.vy = 7.69901118419740425e-03 * DAYS_PER_YEAR
            p.vz = -6.90460016972063023e-05 * DAYS_PER_YEAR
            p.mass = 9.54791938424326609e-04 * SOLAR_MASS
            return p
        }

        fun saturn(): Body {
            val p = Body()
            p.x = 8.34336671824457987e+00
            p.y = 4.12479856412430479e+00
            p.z = -4.03523417114321381e-01
            p.vx = -2.76742510726862411e-03 * DAYS_PER_YEAR
            p.vy = 4.99852801234917238e-03 * DAYS_PER_YEAR
            p.vz = 2.30417297573763929e-05 * DAYS_PER_YEAR
            p.mass = 2.85885980666130812e-04 * SOLAR_MASS
            return p
        }

        fun uranus(): Body {
            val p = Body()
            p.x = 1.28943695621391310e+01
            p.y = -1.51111514016986312e+01
            p.z = -2.23307578892655734e-01
            p.vx = 2.96460137564761618e-03 * DAYS_PER_YEAR
            p.vy = 2.37847173959480950e-03 * DAYS_PER_YEAR
            p.vz = -2.96589568540237556e-05 * DAYS_PER_YEAR
            p.mass = 4.36624404335156298e-05 * SOLAR_MASS
            return p
        }

        fun neptune(): Body {
            val p = Body()
            p.x = 1.53796971148509165e+01
            p.y = -2.59193146099879641e+01
            p.z = 1.79258772950371181e-01
            p.vx = 2.68067772490389322e-03 * DAYS_PER_YEAR
            p.vy = 1.62824170038242295e-03 * DAYS_PER_YEAR
            p.vz = -9.51592254519715870e-05 * DAYS_PER_YEAR
            p.mass = 5.15138902046611451e-05 * SOLAR_MASS
            return p
        }

        fun sun(): Body {
            val p = Body()
            p.mass = SOLAR_MASS
            return p
        }
    }
}