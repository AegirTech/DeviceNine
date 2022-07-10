package moe.dazecake.pojo

data class LockTaskListData(
    val code: Int,
    val `data`: HashMap<String, Data>,
    val msg: String
) {
    data class Data(
        val account: AccountData,
        val time: String
    )
}