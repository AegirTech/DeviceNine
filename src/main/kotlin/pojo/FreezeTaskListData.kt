package moe.dazecake.pojo

data class FreezeTaskListData(
    val code: Int,
    val msg: String,
    val data: HashMap<Long, String>
)
