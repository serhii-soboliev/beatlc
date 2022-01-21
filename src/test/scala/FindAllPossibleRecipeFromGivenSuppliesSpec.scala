package org.sbk.leet

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class FindAllPossibleRecipeFromGivenSuppliesSpec extends AnyFlatSpec with Matchers{

    "A FindAllPossibleRecipeFromGivenSupplies TopologicalSearch" should "return List('bread')" in {
        val testInstance = new FindAllPossibleRecipeFromGivenSupplies
        testInstance.findAllRecipesTopologicalSearch(Array("bread"),
            List(List("yeast", "flour")),
            Array("yeast", "flour", "corn")
        ) should contain ("bread")
    }

    "A FindAllPossibleRecipeFromGivenSupplies TopologicalSearch" should "return List('bread','sandwitch')" in {
        val testInstance = new FindAllPossibleRecipeFromGivenSupplies
        testInstance.findAllRecipesTopologicalSearch(Array("bread","sandwich"),
            List(List("yeast", "flour"), List("bread","meat")),
            Array("yeast","flour","meat")
        ) should contain allOf("bread", "sandwich")
    }

    "A FindAllPossibleRecipeFromGivenSupplies TopologicalSearch" should "return List('bread','sandwitch','burger')" in {
        val testInstance = new FindAllPossibleRecipeFromGivenSupplies
        testInstance.findAllRecipesTopologicalSearch(Array("bread","sandwich","burger"),
            List(List("yeast", "flour"), List("bread","meat"), List("sandwich","meat","bread")),
            Array("yeast","flour","meat")
        ) should contain allOf("bread", "sandwich", "burger")
    }

    "A FindAllPossibleRecipeFromGivenSuppliesNaive" should "return List('bread')" in {
        val testInstance = new FindAllPossibleRecipeFromGivenSupplies
        testInstance.findAllRecipesNaive(Array("bread"),
            List(List("yeast", "flour")),
            Array("yeast", "flour", "corn")
        ) should contain ("bread")
    }

}
