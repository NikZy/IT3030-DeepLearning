import IT3030.DeepLearning.Config.ConfigParser

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertFalse

class ConfigParserSpec : Spek({

    describe("#${ConfigParser::readFile.name}") {
      assertFalse { true }

    }

})