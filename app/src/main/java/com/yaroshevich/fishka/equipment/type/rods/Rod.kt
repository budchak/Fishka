package com.yaroshevich.fishka.equipment.type.rods

class Rod(var brand: String = "", var model: String = "", var height: Int = -1, var test: Test = Test() ) {

}

class Test(var min: Int = -1, var max: Int = -1)