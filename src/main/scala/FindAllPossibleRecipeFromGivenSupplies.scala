package org.sbk.leet



class FindAllPossibleRecipeFromGivenSupplies {

    def findAllRecipes(recipes: Array[String],
                       ingredients: List[List[String]],
                       supplies: Array[String]): List[String] = {
        import scala.collection.mutable

        val prep: mutable.HashSet[String] = supplies.to(mutable.HashSet)
        val n = recipes.length

        def prepare(): Boolean = {
            import scala.util.control.Breaks._
            var isPrepared: Boolean = false
            for (i <- 0 until n) {
                breakable {
                    val recipe = recipes(i)
                    if (prep.contains(recipes(i))) break
                    val rIngredients = ingredients(i)
                    for (ri <- rIngredients) {
                        if (!prep.contains(ri)) break
                    }
                    prep += recipe
                    isPrepared = true
                }
            }
            isPrepared
        }

        def prepareWhilePossible(): Unit = {
            var couldBePrepared = true
            while(couldBePrepared) {
                couldBePrepared = prepare()
            }
        }

        def buildAnswer(): List[String] = {
            import scala.collection.mutable.ListBuffer
            val ans = ListBuffer[String]()
            for(recipe <- recipes) {
                if(prep.contains(recipe)) {
                    ans += recipe
                }
            }
            ans.toList
        }

        prepareWhilePossible()
        buildAnswer()
    }

}
