package moe.dazecake

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.value

object DeviceNineConfig: AutoSavePluginConfig("DeviceNineConfig") {

    val baseUrl:String by value()

    val root:Long by value()

    val adminAccount:String by value()

    val adminPassword:String by value()
}