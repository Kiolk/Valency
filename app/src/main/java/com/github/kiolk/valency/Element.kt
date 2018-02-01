package com.github.kiolk.valency

import java.util.*

data class Element(val name: String, val symbol: String, val isvalencConstantValency: Boolean, val valencies: List<Int>)

fun allElements(): List<Element> {
    val list = mutableListOf<Element>()
    list.add(Element("Potassium", "K", true, listOf(1)))
    list.add(Element("Lithium", "Li", true, listOf(1)))
    list.add(Element("Cesium", "Cs", true, listOf(1)))
    list.add(Element("Sodium", "Na", true, listOf(1)))
    list.add(Element("Rubidium", "Rb", true, listOf(1)))
    list.add(Element("Florine", "F", true, listOf(1)))


    list.add(Element("Beryllium", "Be", true, listOf(2)))
    list.add(Element("Magnesium", "Mg", true, listOf(2)))
    list.add(Element("Calcium", "Ca", true, listOf(2)))
    list.add(Element("Barium", "Ba", true, listOf(2)))
    list.add(Element("Strontium", "Sr", true, listOf(2)))
    list.add(Element("Zinc", "Zn", true, listOf(2)))
    list.add(Element("Oxygen", "O", true, listOf(2)))

    list.add(Element("Aluminium", "Al", true, listOf(3)))
    list.add(Element("Boron", "B", true, listOf(3)))

    list.add(Element("Iron", "Fe", false, listOf(2, 3)))
    list.add(Element("Copper", "Cu", false, listOf(1, 2)))

    list.add(Element("Carbon", "C", false, listOf(2, 4)))
    list.add(Element("Silicon", "Si", false, listOf(2, 4)))

    list.add(Element("Nitrogen", "N", false, listOf(1, 2, 3, 4)))
    list.add(Element("Phosphorus", "P", false, listOf(3, 5)))
    list.add(Element("Sulfur", "S", false, listOf(2, 4, 6)))

    list.add(Element("Chlorine", "Cl", false, listOf(1, 3, 5, 7)))
    list.add(Element("Bromine", "Br", false, listOf(1, 3, 5, 7)))
    list.add(Element("Iodine", "I", false, listOf(1, 3, 5, 7)))
    return list
//    {
//
//        Element("Lithium", "Li", true, listOf(1))
//        Element("Sodium", "Na", true, listOf(1))
//        Element("Rubidium", "Rb", true, listOf(1))
//
//        Element("Beryllium", "Be", true, listOf(2))
//        Element("Potassium", "Mg", true, listOf(2))
//
//        Element("Iron", "Fe", false, listOf(2, 3))
//
//        Element("Chlorine", "Cl", true, listOf(1, 3, 5, 7))
//    }
}

fun getElement(name: String): Element {
    return allElements().find { it.name == name } ?: allElements().first()
}

fun randomElement(): Element {
    val random = Random()
    val randomNumber = random.nextInt(allElements().size - 1)
    return allElements().get(randomNumber)
}