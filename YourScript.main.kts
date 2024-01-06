import java.io.File
val file = File("versions.toml")

var result = ""
file.readLines().forEach {
    println(it)
    val list = it.split("=")
    println(list)
    if (list.size >= 2) {
        if(list[0] == "pluginVersion" ) {
            val (major, minor, patch) = list[1].split(".")
            val newPatch = patch.toInt()  + 1 
            result = listOf(major, minor, newPatch).joinToString(".")
            println(result)
            if (result.isNotEmpty()) {
                return@forEach
            }
        }
    }
}
println(result)

