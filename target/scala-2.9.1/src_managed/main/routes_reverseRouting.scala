// @SOURCE:/Users/jinsu0411/Documents/soma2/conf/routes
// @HASH:ff22093e1c2de038da57cf75cc0c6fd972ffabb5
// @DATE:Sun Nov 04 23:20:02 KST 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:25
// @LINE:21
// @LINE:18
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
package controllers {

// @LINE:25
class ReverseAssets {
    


 
// @LINE:25
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            

// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:7
class ReverseRestApp {
    


 
// @LINE:11
def getUserLookById(id:Long) = {
   Call("GET", "/api/userLook/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        
 
// @LINE:10
def getAllUserLooksByLookId(id:Long) = {
   Call("GET", "/api/looks/" + implicitly[PathBindable[Long]].unbind("id", id) + "/userLooks")
}
                                                        
 
// @LINE:9
def getLookById(id:Long) = {
   Call("GET", "/api/looks/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        
 
// @LINE:13
def saveUserLook() = {
   Call("POST", "/api/userLook")
}
                                                        
 
// @LINE:7
def getLooks(year:String = null, season:String = null, lookType:String = null) = {
   Call("GET", "/api/looks" + queryString(List(if(year == null) None else Some(implicitly[QueryStringBindable[String]].unbind("year", year)), if(season == null) None else Some(implicitly[QueryStringBindable[String]].unbind("season", season)), if(lookType == null) None else Some(implicitly[QueryStringBindable[String]].unbind("lookType", lookType)))))
}
                                                        
 
// @LINE:15
def deleteUserLookById(id:Long) = {
   Call("DELETE", "/api/userLook/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        

                      
    
}
                            

// @LINE:21
class ReverseLogin {
    


 
// @LINE:21
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
                            

// @LINE:18
class ReverseLooks {
    


 
// @LINE:18
def selectLooks() = {
   Call("GET", "/looks")
}
                                                        

                      
    
}
                            
}
                    


// @LINE:25
// @LINE:21
// @LINE:18
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:25
class ReverseAssets {
    


 
// @LINE:25
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:7
class ReverseRestApp {
    


 
// @LINE:11
def getUserLookById = JavascriptReverseRoute(
   "controllers.RestApp.getUserLookById",
   """
      function(id) {
      return _wA({method:"GET", url:"/api/userLook/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:10
def getAllUserLooksByLookId = JavascriptReverseRoute(
   "controllers.RestApp.getAllUserLooksByLookId",
   """
      function(id) {
      return _wA({method:"GET", url:"/api/looks/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/userLooks"})
      }
   """
)
                                                        
 
// @LINE:9
def getLookById = JavascriptReverseRoute(
   "controllers.RestApp.getLookById",
   """
      function(id) {
      return _wA({method:"GET", url:"/api/looks/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:13
def saveUserLook = JavascriptReverseRoute(
   "controllers.RestApp.saveUserLook",
   """
      function() {
      return _wA({method:"POST", url:"/api/userLook"})
      }
   """
)
                                                        
 
// @LINE:7
def getLooks = JavascriptReverseRoute(
   "controllers.RestApp.getLooks",
   """
      function(year,season,lookType) {
      return _wA({method:"GET", url:"/api/looks" + _qS([(year == null ? """ +  implicitly[JavascriptLitteral[String]].to(null) + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("year", year)), (season == null ? """ +  implicitly[JavascriptLitteral[String]].to(null) + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("season", season)), (lookType == null ? """ +  implicitly[JavascriptLitteral[String]].to(null) + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("lookType", lookType))])})
      }
   """
)
                                                        
 
// @LINE:15
def deleteUserLookById = JavascriptReverseRoute(
   "controllers.RestApp.deleteUserLookById",
   """
      function(id) {
      return _wA({method:"DELETE", url:"/api/userLook/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:21
class ReverseLogin {
    


 
// @LINE:21
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
                            

// @LINE:18
class ReverseLooks {
    


 
// @LINE:18
def selectLooks = JavascriptReverseRoute(
   "controllers.Looks.selectLooks",
   """
      function() {
      return _wA({method:"GET", url:"/looks"})
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:25
// @LINE:21
// @LINE:18
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:25
class ReverseAssets {
    


 
// @LINE:25
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            

// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:7
class ReverseRestApp {
    


 
// @LINE:11
def getUserLookById(id:Long) = new play.api.mvc.HandlerRef(
   controllers.RestApp.getUserLookById(id), HandlerDef(this, "controllers.RestApp", "getUserLookById", Seq(classOf[Long]))
)
                              
 
// @LINE:10
def getAllUserLooksByLookId(id:Long) = new play.api.mvc.HandlerRef(
   controllers.RestApp.getAllUserLooksByLookId(id), HandlerDef(this, "controllers.RestApp", "getAllUserLooksByLookId", Seq(classOf[Long]))
)
                              
 
// @LINE:9
def getLookById(id:Long) = new play.api.mvc.HandlerRef(
   controllers.RestApp.getLookById(id), HandlerDef(this, "controllers.RestApp", "getLookById", Seq(classOf[Long]))
)
                              
 
// @LINE:13
def saveUserLook() = new play.api.mvc.HandlerRef(
   controllers.RestApp.saveUserLook(), HandlerDef(this, "controllers.RestApp", "saveUserLook", Seq())
)
                              
 
// @LINE:7
def getLooks(year:String, season:String, lookType:String) = new play.api.mvc.HandlerRef(
   controllers.RestApp.getLooks(year, season, lookType), HandlerDef(this, "controllers.RestApp", "getLooks", Seq(classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:15
def deleteUserLookById(id:Long) = new play.api.mvc.HandlerRef(
   controllers.RestApp.deleteUserLookById(id), HandlerDef(this, "controllers.RestApp", "deleteUserLookById", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:21
class ReverseLogin {
    


 
// @LINE:21
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
                            

// @LINE:18
class ReverseLooks {
    


 
// @LINE:18
def selectLooks() = new play.api.mvc.HandlerRef(
   controllers.Looks.selectLooks(), HandlerDef(this, "controllers.Looks", "selectLooks", Seq())
)
                              

                      
    
}
                            
}
                    
                