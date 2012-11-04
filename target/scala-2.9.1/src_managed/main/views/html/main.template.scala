
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(username :String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.50*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("bootstrap/css/bootstrap.min.css"))),format.raw/*9.105*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*10.54*/routes/*10.60*/.Assets.at("bootstrap/css/bootstrap-responsive.min.css"))),format.raw/*10.116*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*11.59*/routes/*11.65*/.Assets.at("images/favicon.png"))),format.raw/*11.97*/("""">
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("javascripts/jquery-1.8.2.min.js"))),format.raw/*12.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*13.23*/routes/*13.29*/.Assets.at("bootstrap/js/bootstrap.min.js"))),format.raw/*13.72*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*14.23*/routes/*14.29*/.Assets.at("javascripts/highcharts.js"))),format.raw/*14.68*/("""" type="text/javascript"></script>
    </head>
    <body>
    	<div class="navbar navbar-fixed-top navbar-inverse">
    		<div class="navbar-inner">
    			<div class="container">
    				
    				<ul class="nav">
    					<li> <a href="/"> Home </a> </li>
  						<li class="divider-vertical"></li>  						
    					<li class="normal-navbar">
	    					Welcome! """),_display_(Seq[Any](/*25.21*/username)),format.raw/*25.29*/(""" 
    					</li>    					
    					<li>
	    					<a href="/logout">Logout</a>
    					</li>	
    				</ul>
    				<div class = "float-right">    				
    					<a href="/looks" class="btn"> View Product </a>
 					</div>
 				</div>
 			</div>
    	</div>
    	<div class="container container-margin">
    		<div class="row">
	        		"""),_display_(Seq[Any](/*39.13*/content)),format.raw/*39.20*/("""      	
	        </div>
	        
        </div>
        <footer class="footer">
        	<div class="container">
	        	test
	        </div>
	    </footer>
    </body>
</html>
"""))}
    }
    
    def render(title:String,username:String,content:Html) = apply(title)(username)(content)
    
    def f:((String) => (String) => (Html) => play.api.templates.Html) = (title) => (username) => (content) => apply(title)(username)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 05 00:33:10 KST 2012
                    SOURCE: /Users/jinsu0411/Documents/soma2/app/views/main.scala.html
                    HASH: 5b6e29606e1fab7032787a9db68b1d0f637a65c0
                    MATRIX: 766->1|891->49|979->102|1005->107|1102->169|1116->175|1171->209|1262->265|1276->271|1343->316|1435->372|1450->378|1529->434|1626->495|1641->501|1695->533|1756->558|1771->564|1838->609|1931->666|1946->672|2011->715|2081->749|2096->755|2157->794|2557->1158|2587->1166|2963->1506|2992->1513
                    LINES: 27->1|30->1|36->7|36->7|37->8|37->8|37->8|38->9|38->9|38->9|39->10|39->10|39->10|40->11|40->11|40->11|41->12|41->12|41->12|42->13|42->13|42->13|43->14|43->14|43->14|54->25|54->25|68->39|68->39
                    -- GENERATED --
                */
            