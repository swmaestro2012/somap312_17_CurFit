// @SOURCE:/Users/jinsu0411/Documents/soma2/conf/routes
// @HASH:aba3717b530620a92c9f7bb44365a751eb5e5a4a
// @DATE:Sun Nov 04 16:59:47 KST 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:7
val controllers_RestApp_getLookById1 = Route("GET", PathPattern(List(StaticPart("/api/looks/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:8
val controllers_RestApp_getAllUserLooksByLookId2 = Route("GET", PathPattern(List(StaticPart("/api/looks/"),DynamicPart("id", """[^/]+"""),StaticPart("/userLooks"))))
                    

// @LINE:9
val controllers_RestApp_getUserLookById3 = Route("GET", PathPattern(List(StaticPart("/api/userLook/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:11
val controllers_RestApp_saveUserLook4 = Route("POST", PathPattern(List(StaticPart("/api/userLook"))))
                    

// @LINE:13
val controllers_RestApp_deleteUserLookById5 = Route("DELETE", PathPattern(List(StaticPart("/api/userLook/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:16
val controllers_Login_blank6 = Route("GET", PathPattern(List(StaticPart("/login"))))
                    

// @LINE:19
val controllers_Assets_at7 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.index()"""),("""GET""","""/api/looks/$id<[^/]+>""","""controllers.RestApp.getLookById(id:Long)"""),("""GET""","""/api/looks/$id<[^/]+>/userLooks""","""controllers.RestApp.getAllUserLooksByLookId(id:Long)"""),("""GET""","""/api/userLook/$id<[^/]+>""","""controllers.RestApp.getUserLookById(id:Long)"""),("""POST""","""/api/userLook""","""controllers.RestApp.saveUserLook()"""),("""DELETE""","""/api/userLook/$id<[^/]+>""","""controllers.RestApp.deleteUserLookById(id:Long)"""),("""GET""","""/login""","""controllers.Login.blank()"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:7
case controllers_RestApp_getLookById1(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.RestApp.getLookById(id), HandlerDef(this, "controllers.RestApp", "getLookById", Seq(classOf[Long])))
   }
}
                    

// @LINE:8
case controllers_RestApp_getAllUserLooksByLookId2(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.RestApp.getAllUserLooksByLookId(id), HandlerDef(this, "controllers.RestApp", "getAllUserLooksByLookId", Seq(classOf[Long])))
   }
}
                    

// @LINE:9
case controllers_RestApp_getUserLookById3(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.RestApp.getUserLookById(id), HandlerDef(this, "controllers.RestApp", "getUserLookById", Seq(classOf[Long])))
   }
}
                    

// @LINE:11
case controllers_RestApp_saveUserLook4(params) => {
   call { 
        invokeHandler(_root_.controllers.RestApp.saveUserLook(), HandlerDef(this, "controllers.RestApp", "saveUserLook", Nil))
   }
}
                    

// @LINE:13
case controllers_RestApp_deleteUserLookById5(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.RestApp.deleteUserLookById(id), HandlerDef(this, "controllers.RestApp", "deleteUserLookById", Seq(classOf[Long])))
   }
}
                    

// @LINE:16
case controllers_Login_blank6(params) => {
   call { 
        invokeHandler(_root_.controllers.Login.blank(), HandlerDef(this, "controllers.Login", "blank", Nil))
   }
}
                    

// @LINE:19
case controllers_Assets_at7(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                