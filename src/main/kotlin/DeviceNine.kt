package moe.dazecake

import kotlinx.coroutines.launch
import moe.dazecake.command.CDKQueryCommand
import moe.dazecake.command.StateQueryCommand
import moe.dazecake.http.TokenGetter
import net.mamoe.mirai.console.command.CommandManager.INSTANCE.register
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

        launch {
            if (TokenGetter.getToken().isNullOrEmpty()) {
                logger.warning("Token 获取失败，无法连接至审判庭")
            }
        }
        StateQueryCommand.register()
        CDKQueryCommand.register()

        logger.info { "Plugin loaded" }
    }
}