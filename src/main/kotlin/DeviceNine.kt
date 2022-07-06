package moe.dazecake

import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info

object DeviceNine : KotlinPlugin(
    JvmPluginDescription(
        id = "moe.dazecake.DeviceNine",
        name = "DeviceNine",
        version = "1.0-SNAPSHOT",
    ) {
        author("DazeCake")
        info("""明日方舟速通云控机器人""")
    }
) {
    override fun onEnable() {

        DeviceNineConfig.reload()

        logger.info { "Plugin loaded" }
    }
}