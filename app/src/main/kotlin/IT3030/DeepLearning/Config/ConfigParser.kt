package IT3030.DeepLearning.Config

import com.charleskorn.kaml.Yaml
import java.io.File

class ConfigParser(val fileName: String) {

    val config: Config = parseString(readFile())

    private fun readFile(): String {
        val fileString = File(this.fileName)
            .readText()
        return fileString
    }
    private fun parseString(str: String): Config = Yaml.default.decodeFromString(Config.serializer(), str)
}

fun main() {
    val configParser = ConfigParser("config.yml")
    println("Hei")
}
