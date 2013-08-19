package controllers

import play.api._
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import models.Task

object Application extends Controller {
  
  // redirect index to tasks page
  def index = Action {
    Redirect(routes.Application.tasks)
  }

  // task response: display tasks and form
  def tasks = Action {
    Ok(views.html.index(Task.all(), taskForm))
  }
  
  // taskForm: submit new task
  val taskForm = Form(
    "label" -> nonEmptyText
  )
  
  // newTask form
  def newTask = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.index(Task.all(), errors)),
      label => {
        Task.create(label)
        Redirect(routes.Application.tasks)
      }
    )
  }

  def deleteTask(id: Long) = TODO

}
