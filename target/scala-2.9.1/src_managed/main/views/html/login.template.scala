
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.api.templates.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import com.avaje.ebean._
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object login extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply/*1.2*/():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.4*/("""


<!DOCTYPE html>

<html>
    <head>
        <title>Login Page</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("stylesheets/main.css"))),format.raw/*9.94*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*10.54*/routes/*10.60*/.Assets.at("bootstrap/css/bootstrap.min.css"))),format.raw/*10.105*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*11.54*/routes/*11.60*/.Assets.at("bootstrap/css/bootstrap-responsive.min.css"))),format.raw/*11.116*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*12.59*/routes/*12.65*/.Assets.at("images/favicon.png"))),format.raw/*12.97*/("""">
        
    </head>
    <body>
    <div class ="cover" style="background-image : url('"""),_display_(Seq[Any](/*16.57*/routes/*16.63*/.Assets.at("images/blurIndex.png"))),format.raw/*16.97*/("""')">
    	"""),format.raw/*17.77*/("""
    	<form action="/" method="POST">
    	<div class="modal">
    		<div class="modal-header">
    			<h3> Sign in to Fashion Dashboard. </h3>
    		</div>
    		<div class="modal-body">
    			<div>
	    			<input name="username" class ="inputbox" placeholder="Username" type="text"/>
	    		</div>
	    		<div>
	    			<input name="password" class = "inputbox" placeholder="Password" type="password"/>
	    		</div>    		
			</div>
			<div class="modal-footer">	
				<input class="pull-right btn btn-primary" type="submit" value="Submit"/>
			</div>
        </div>
        </form> 
    </div>
    """),format.raw/*58.7*/("""
        <script src=""""),_display_(Seq[Any](/*59.23*/routes/*59.29*/.Assets.at("javascripts/jquery-1.8.2.min.js"))),format.raw/*59.74*/("""" type="text/javascript"></script>
    </body>
</html>
	
	

"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 05 00:03:02 KST 2012
                    SOURCE: /Users/jinsu0411/Documents/soma2/app/views/login.scala.html
                    HASH: ede76f6e2bbf0210618389682e2b15b0d0ab75a9
                    MATRIX: 748->1|826->3|986->128|1000->134|1055->168|1147->224|1162->230|1230->275|1322->331|1337->337|1416->393|1513->454|1528->460|1582->492|1709->583|1724->589|1780->623|1818->704|2445->1789|2504->1812|2519->1818|2586->1863
                    LINES: 27->1|30->1|38->9|38->9|38->9|39->10|39->10|39->10|40->11|40->11|40->11|41->12|41->12|41->12|45->16|45->16|45->16|46->17|66->58|67->59|67->59|67->59
                    -- GENERATED --
                */
            