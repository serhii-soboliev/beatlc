package org.sbk.leet

import org.scalatest.flatspec.AnyFlatSpec

/*
  2115. Find All Possible Recipes from Given Supplies
  https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
 */
class FindAllPossibleRecipeFromGivenSuppliesSpec extends AnyFlatSpec {

    "A FindAllPossibleRecipeFromGivenSupplies" should "return List('bread')" in {
        val testInstance = new FindAllPossibleRecipeFromGivenSupplies
        val res = testInstance.findAllRecipes(
            Array("bread"),
            List(List("yeast", "flour")),
            Array("yeast", "flour", "corn")
        )
        assert(res == List("bread"))
    }

}
