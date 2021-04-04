import com.alphamail.plugin.api.AlphamailPlugin
import java.net.URL
import java.net.URLClassLoader
import kotlin.jvm.internal.Reflection
import kotlin.reflect.full.createInstance

class Loader {

    fun load(uri: String): Any? {
        val child = URLClassLoader(arrayOf(URL(uri)), this.javaClass.classLoader)
        val classToLoad = Class.forName("me.cjavellana.lib.SomeLib", true, child)
        val kClass = Reflection.createKotlinClass(classToLoad)

        val instance = kClass.createInstance() as AlphamailPlugin
        return instance.beforeSend()
    }

}


fun main(args: Array<String>) {
    val lib = "file:./lib/build/libs/lib-1.0.jar"
    val loader = Loader()
    println(loader.load(lib))
}