fun twoOldestAges(ages: List<Int>): List<Int> {

    val max = ages.max()
    val maxIndex = ages.indexOf(max)
    var agesWithoutMax1 = Integer.MIN_VALUE
    if (maxIndex >0) {
        agesWithoutMax1 = ages.subList(0, maxIndex).max() as Int
    }
    ages.subList(0, maxIndex).max()

    var agesWithoutMax2 = Integer.MIN_VALUE
    if (maxIndex < ages.size - 1) {
        agesWithoutMax2 = ages.subList(maxIndex + 1, ages.size).max() as Int
    }
    val res = ArrayList<Int>()

    res.add(Math.max(agesWithoutMax1, agesWithoutMax2))
    res.add(max as Int)
    return res
}