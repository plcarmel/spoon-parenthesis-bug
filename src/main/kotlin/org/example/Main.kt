package org.example

import spoon.Launcher
import spoon.reflect.code.CtLocalVariable
import spoon.reflect.reference.CtLocalVariableReference
import spoon.support.sniper.SniperJavaPrettyPrinter

fun main() {
    val launcher = Launcher()
    launcher.environment.setPrettyPrinterCreator { SniperJavaPrettyPrinter(launcher.environment) }
    launcher.addInputResource("./srcToTransform")
    val model = launcher.buildModel()
    val t = model.allTypes.first { it.simpleName.equals("Example") }
    val m = t.allMethods.first { it.simpleName.equals("example") }
    m.getElements<CtLocalVariable<*>> { it is CtLocalVariable<*> && it.simpleName == "a" }.first().setSimpleName<CtLocalVariable<*>>("b")
    m.getElements<CtLocalVariableReference<*>> { it is CtLocalVariableReference<*> && it.simpleName == "a" }.first().setSimpleName<CtLocalVariableReference<*>>("b")
    launcher.prettyprint()
}