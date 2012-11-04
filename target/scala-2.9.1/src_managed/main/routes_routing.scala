// @SOURCE:/Users/jinsu0411/Documents/soma2/conf/routes
// @HASH:9c88ccb541a682c8329066689180b47eee67b3e7
// @DATE:Sun Nov 04 18:19:45 KST 2012

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
val controllers_RestApp_getLooks1 = Route("GET", PathPattern(List(StaticPart("/api/looks"))))
                    

// @LINE:9
val controllers_RestApp_getLookById2 = Route("GET", PathPattern(List(StaticPart("/api/looks/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:10
val controllers_RestApp_getAllUserLooksByLookId3 = Route("GET", PathPattern(List(StaticPart("/api/looks/"),DynamicPart("id", """[^/]+"""),StaticPart("/userLooks"))))
                    

// @LINE:11
val controllers_RestApp_getUserLookById4 = Route("GET", PathPattern(List(StaticPart("/api/userLook/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:13
val controllers_RestApp_saveUserLook5 = Route("POST", PathPattern(List(StaticPart("/api/userLook"))))
                    

// @LINE:15
val controllers_RestApp_deleteUserLookById6 = Route("DELETE", PathPattern(List(StaticPart("/api/userLook/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:18
val controllers_Login_blank7 = Route("GET", PathPattern(List(StaticPart("/login"))))
                    

// @LINE:21
val controllers_Assets_at8 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.index()"""),("""GET""","""/api/looks""","""controllers.RestApp.getLooks(year:String ?= null, season:String ?= null, lookType:String ?= null)"""),("""GET""","""/api/looks/$id<[^/]+>""","""controllers.RestApp.getLookById(id:Long)"""),("""GET""","""/api/looks/$id<[^/]+>/userLooks""","""controllers.RestApp.getAllUserLooksByLookId(id:Long)"""),("""GET""","""/api/userLook/$id<[^/]+>""","""controllers.RestApp.getUserLookById(id:Long)"""),("""POST""","""/api/userLook""","""controllers.RestApp.saveUserLook()"""),("""DELETE""","""/api/userLook/$id<[^/]+>""","""controllers.RestApp.deleteUserLookById(id:Long)"""),("""GET""","""/login""","""controllers.Login.blank()"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:7
case controllers_RestApp_getLooks1(params) => {
   call(params.fromQuery[String]("year", Some(null)), params.fromQuery[String]("season", Some(null)), params.fromQuery[String]("lookType", Some(null))) { (year, season, lookType) =>
        invokeHandler(_root_.controllers.RestApp.getLooks(year, season, lookType), HandlerDef(this, "controllers.RestApp", "getLooks", Seq(classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:9
case controllers_RestApp_getLookById2(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.RestApp.getLookById(id), HandlerDef(this, "controllers.RestApp", "getLookById", Seq(classOf[Long])))
   }
}
                    

// @LINE:10
case controllers_RestApp_getAllUserLooksByLookId3(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.RestApp.getAllUserLooksByLookId(id), HandlerDef(this, "controllers.RestApp", "getAllUserLooksByLookId", Seq(classOf[Long])))
   }
}
                    

// @LINE:11
case controllers_RestApp_getUserLookById4(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.RestApp.getUserLookById(id), HandlerDef(this, "controllers.RestApp", "getUserLookById", Seq(classOf[Long])))
   }
}
                    

// @LINE:13
case controllers_RestApp_saveUserLook5(params) => {
   call { 
        invokeHandler(_root_.controllers.RestApp.saveUserLook(), HandlerDef(this, "controllers.RestApp", "saveUserLook", Nil))
   }
}
                    

// @LINE:15
case controllers_RestApp_deleteUserLookById6(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.RestApp.deleteUserLookById(id), HandlerDef(this, "controllers.RestApp", "deleteUserLookById", Seq(classOf[Long])))
   }
}
                    

// @LINE:18
case controllers_Login_blank7(params) => {
   call { 
        invokeHandler(_root_.controllers.Login.blank(), HandlerDef(this, "controllers.Login", "blank", Nil))
   }
}
                    

// @LINE:21
case controllers_Assets_at8(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                