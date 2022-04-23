class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val users = mutableMapOf<String, MutableList<String>>()
        id_list.forEach {
            users[it] = arrayListOf()
        }

        report.distinct().forEach { r ->
            r.split(" ").let {
                users[it[1]]!!.add(it[0])
            }
        }

        val answer = IntArray(id_list.size)
        users.forEach {
            if(it.value.size >= k) {
                id_list.forEachIndexed { index, user ->
                    it.value.forEach { reporter ->
                        if(reporter == user) {
                            answer[index]++
                        }
                    }
                }
            }
        }    
        
        return answer
    }
}

/*	베스트 풀이
class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray =
    report.map { it.split(" ") }
        .groupBy { it[1] }
        .asSequence()
        .map { it.value.distinct() }
        .filter { it.size >= k }
        .flatten()
        .map { it[0] }
        .groupingBy { it }
        .eachCount()
        .run { id_list.map { getOrDefault(it, 0) }.toIntArray() }
}
*/