package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("If we knew what it was we were doing, it would not be called research, would it?"))
  }
  
}
