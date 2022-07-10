package moe.dazecake.pojo

data class AccountData(
    val account: String,
    val active: Active,
    val config: Config,
    val delete: Int,
    val expireTime: String,
    val id: Int,
    val name: String,
    val password: String,
    val server: Int,
    val taskType: String
) {
    data class Active(
        val friday: Friday,
        val monday: Monday,
        val saturday: Saturday,
        val sunday: Sunday,
        val thursday: Thursday,
        val tuesday: Tuesday,
        val wednesday: Wednesday
    ) {
        data class Friday(
            val detail: List<String>,
            val enable: Boolean
        )

        data class Monday(
            val detail: List<String>,
            val enable: Boolean
        )

        data class Saturday(
            val detail: List<String>,
            val enable: Boolean
        )

        data class Sunday(
            val detail: List<String>,
            val enable: Boolean
        )

        data class Thursday(
            val detail: List<String>,
            val enable: Boolean
        )

        data class Tuesday(
            val detail: List<String>,
            val enable: Boolean
        )

        data class Wednesday(
            val detail: List<String>,
            val enable: Boolean
        )
    }

    data class Config(
        val daily: Daily,
        val rogue: Rogue
    ) {
        data class Daily(
            val activity: Boolean,
            val credit: Boolean,
            val fight: List<Fight>,
            val friend: Boolean,
            val infrastructure: Infrastructure,
            val mail: Boolean,
            val offer: Offer,
            val sanity: Sanity,
            val task: Boolean
        ) {
            data class Fight(
                val level: String,
                val num: Int
            )

            data class Infrastructure(
                val acceleration: Boolean,
                val communication: Boolean,
                val deputy: Boolean,
                val harvest: Boolean,
                val shift: Boolean
            )

            data class Offer(
                val car: Boolean,
                val enable: Boolean,
                val other: Boolean,
                val star4: Boolean,
                val star5: Boolean,
                val star6: Boolean
            )

            data class Sanity(
                val drug: Int,
                val stone: Int
            )
        }

        data class Rogue(
            val coin: Int,
            val level: Int,
            val `operator`: Operator,
            val skip: Skip
        ) {
            data class Operator(
                val index: Int,
                val num: Int,
                val skill: Int
            )

            data class Skip(
                val beast: Boolean,
                val coin: Boolean,
                val daily: Boolean,
                val illusion: Boolean,
                val sensitive: Boolean,
                val survive: Boolean
            )
        }
    }
}