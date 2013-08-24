package models

import com.novus.salat._
import play.api.Play.current

package object salatctx {
  implicit val ctx = {
    val context = new Context{
      val name = "global"
      override val typeHintStrategy = StringTypeHintStrategy(when = TypeHintFrequency.WhenNecessary, typeHint = "_t")
    }
    context.registerGlobalKeyOverride(remapThis = "id", toThisInstead = "_id")
    context.registerClassLoader(current.classloader)
    context
  }
}
