package org.sbk.leet
package topologicalsort

/*
  2115. Find All Possible Recipes from Given Supplies
  https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
 */
class FindAllPossibleRecipeFromGivenSupplies {

    def findAllRecipesTopologicalSort2(recipes: Array[String],
                                       ingredients: List[List[String]],
                                       supplies: Array[String]): List[String] = {
        import scala.collection.mutable
        import scala.collection.mutable._

        val answer = new mutable.HashSet[String]
        val ingredientsCopy: List[ListBuffer[String]] = ingredients.map(il => il.to(ListBuffer))
        val suppCopy = supplies.to(mutable.HashSet)
        val suppQueue = supplies.to(mutable.Queue)
        while (suppQueue.nonEmpty) {
            val supply = suppQueue.dequeue()
            for((x,i) <- ingredientsCopy.zipWithIndex) {
                x -= supply
                if(x.isEmpty) {
                    val r = recipes(i)
                    if(!suppCopy.contains(r)) {
                        suppCopy += r
                        suppQueue += r
                    }
                    answer += recipes(i)
                }

            }
        }
        answer.toList
    }

    def findAllRecipesTopologicalSearch(recipes: Array[String],
                                        ingredients: List[List[String]],
                                        supplies: Array[String]): List[String] = {
        import scala.collection.mutable
        import scala.collection.mutable._

        val recipeToIngredient = new mutable.HashMap[String, ArrayBuffer[String]]
        val ingredientToReceipt = new mutable.HashMap[String, ArrayBuffer[String]]
          .withDefaultValue(new ArrayBuffer[String]())

        (recipes zip ingredients).foreach {
            case (recipe, ingredients) =>
                recipeToIngredient(recipe) = ingredients.to(ArrayBuffer)
                ingredients foreach {
                    ingredient => {
                        ingredientToReceipt(ingredient) :+= recipe
                    }
                }
        }

        val supplyQueue = supplies.to(mutable.Queue)
        while (supplyQueue.nonEmpty) {
            val supply = supplyQueue.dequeue()
            ingredientToReceipt(supply) foreach (
              recipe => {
                  recipeToIngredient(recipe) -= supply
                  if (recipeToIngredient(recipe).isEmpty) {
                      supplyQueue += recipe
                  }
              }
              )
        }
        recipeToIngredient.filterInPlace((_, v) => v.isEmpty).keySet.toList
    }

    def findAllRecipesNaive(recipes: Array[String],
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
            while (prepare()) {}
        }

        def buildAnswer(): List[String] = {
            recipes.filter(r => prep.contains(r)).toList
        }

        prepareWhilePossible()
        buildAnswer()
    }

}
