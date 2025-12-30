package ah.lada.lada

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform