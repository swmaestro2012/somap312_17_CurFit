// @SOURCE:/Users/jinsu0411/Documents/soma2/conf/routes
// @HASH:aba3717b530620a92c9f7bb44365a751eb5e5a4a
// @DATE:Sun Nov 04 16:59:47 KST 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:19
// @LINE:16
// @LINE:13
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:13
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseRestApp {
    


 
// @LINE:9
def getUserLookById(id:Long) = {
   Call("GET", "/api/userLook/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        
 
// @LINE:8
def getAllUserLooksByLookId(id:Long) = {
   Call("GET", "/api/looks/" + implicitly[PathBindable[Long]].unbind("id", id) + "/userLooks")
}
                                                        
 
// @LINE:7
def getLookById(id:Long) = {
   Call("GET", "/api/looks/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        
 
// @LINE:11
def saveUserLook() = {
   Call("POST", "/api/userLook")
}
                                                        
 
// @LINE:13
def deleteUserLookById(id:Long) = {
   Call("DELETE", "/api/userLook/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        

                      
    
}
                            

// @LINE:16
class ReverseLogin {
    


 
// @LINE:16
def blank() = {
   Call("GET", "/login")
}
                                                        

                      
    
}
                            

// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def index() = {
   Call("GET", "/")
}
                                                        

                      
    
}
                            

// @LINE:19
class ReverseAssets {
    


 
// @LINE:19
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            
}
                    


// @LINE:19
// @LINE:16
// @LINE:13
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:13
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseRestApp {
    


 
// @LINE:9
def getUserLookById = JavascriptReverseRoute(
   "controllers.RestApp.getUserLookById",
   """
      function(id) {
      return _wA({method:"GET", url:"/api/userLook/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:8
def getAllUserLooksByLookId = JavascriptReverseRoute(
   "controllers.RestApp.getAllUserLooksByLookId",
   """
      function(id) {
      return _wA({method:"GET", url:"/api/looks/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/userLooks"})
      }
   """
)
                                                        
 
// @LINE:7
def getLookById = JavascriptReverseRoute(
   "controllers.RestApp.getLookById",
   """
      function(id) {
      return _wA({method:"GET", url:"/api/looks/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:11
def saveUserLook = JavascriptReverseRoute(
   "controllers.RestApp.saveUserLook",
   """
      function() {
      return _wA({method:"POST", url:"/api/userLook"})
      }
   """
)
                                                        
 
// @LINE:13
def deleteUserLookById = JavascriptReverseRoute(
   "controllers.RestApp.deleteUserLookById",
   """
      function(id) {
      return _wA({method:"DELETE", url:"/api/userLook/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:16
class ReverseLogin {
    


 
// @LINE:16
def blank = JavascriptReverseRoute(
   "controllers.Login.blank",
   """
      function() {
      return _wA({method:"GET", url:"/login"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"/"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:19
class ReverseAssets {
    


 
// @LINE:19
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:19
// @LINE:16
// @LINE:13
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:13
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseRestApp {
    


 
// @LINE:9
def getUserLookById(id:Long) = new play.api.mvc.HandlerRef(
   controllers.RestApp.getUserLookById(id), HandlerDef(this, "controllers.RestApp", "getUserLookById", Seq(classOf[Long]))
)
                              
 
// @LINE:8
def getAllUserLooksByLookId(id:Long) = new play.api.mvc.HandlerRef(
   controllers.RestApp.getAllUserLooksByLookId(id), HandlerDef(this, "controllers.RestApp", "getAllUserLooksByLookId", Seq(classOf[Long]))
)
                              
 
// @LINE:7
def getLookById(id:Long) = new play.api.mvc.HandlerRef(
   controllers.RestApp.getLookById(id), HandlerDef(this, "controllers.RestApp", "getLookById", Seq(classOf[Long]))
)
                              
 
// @LINE:11
def saveUserLook() = new play.api.mvc.HandlerRef(
   controllers.RestApp.saveUserLook(), HandlerDef(this, "controllers.RestApp", "saveUserLook", Seq())
)
                              
 
// @LINE:13
def deleteUserLookById(id:Long) = new play.api.mvc.HandlerRef(
   controllers.RestApp.deleteUserLookById(id), HandlerDef(this, "controllers.RestApp", "deleteUserLookById", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:16
class ReverseLogin {
    


 
// @LINE:16
def blank() = new play.api.mvc.HandlerRef(
   controllers.Login.blank(), HandlerDef(this, "controllers.Login", "blank", Seq())
)
                              

                      
    
}
                            

// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              

                      
    
}
                            

// @LINE:19
class ReverseAssets {
    


 
// @LINE:19
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            
}
                    
                