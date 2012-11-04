
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
object selection extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title :String)(username :String):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.35*/("""


"""),_display_(Seq[Any](/*4.2*/main(title)(username)/*4.23*/{_display_(Seq[Any](format.raw/*4.24*/("""
	<h1> Years </h1>
	
	<input id="years_" type="text">

	<h1> Season </h1>
	<div id ="season" class="btn-group" data-toggle="buttons-radio">
		<button class = "btn"> 봄  </button>
		<button class = "btn"> 여름 </button>
		<button class = "btn"> 가을 </button>
		<button class = "btn"> 겨울 </button>
	</div>
	
	<h1> 상/하의 </h1>
	<div class="btn-group" data-toggle="buttons-radio">
		<button class = "btn"> 상의  </button>
		<button class = "btn"> 하의 </button>		
	</div>
	
	<h1> Price </h1>
	<input type="text">
	
	<script src=""""),_display_(Seq[Any](/*26.16*/routes/*26.22*/.Assets.at("javascripts/looks.js"))),format.raw/*26.56*/(""""> </script>
""")))})))}
    }
    
    def render(title:String,username:String) = apply(title)(username)
    
    def f:((String) => (String) => play.api.templates.Html) = (title) => (username) => apply(title)(username)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 05 01:59:51 KST 2012
                    SOURCE: /Users/jinsu0411/Documents/soma2/app/views/selection.scala.html
                    HASH: 777ce5bd81aaa21b45bbdb0ed6c600627be9e542
                    MATRIX: 766->1|876->34|914->38|943->59|981->60|1534->577|1549->583|1605->617
                    LINES: 27->1|30->1|33->4|33->4|33->4|55->26|55->26|55->26
                    -- GENERATED --
                */
            