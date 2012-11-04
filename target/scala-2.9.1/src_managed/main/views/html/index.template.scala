
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title :String)(username :String):play.api.templates.Html = {
        _display_ {
def /*33.2*/table/*33.7*/(title :String, id :String):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*33.38*/("""
	<div class="accordion table-margin">
  		<div class="accordion-group">
    		<div class="accordion-heading">
    			<a class="accordion-toggle" data-toggle="collapse"  href="#"""),_display_(Seq[Any](/*37.68*/id)),format.raw/*37.70*/("""">
     					"""),_display_(Seq[Any](/*38.12*/title)),format.raw/*38.17*/("""
     					<i class="icon-chevron-down pull-right"></i>
    			</a>
    		</div>
    		<div id=""""),_display_(Seq[Any](/*42.17*/id)),format.raw/*42.19*/("""" class="accordion-body collapse in">
    			<div class="accordion-inner">
    				<table class="table">
    					<thead>
    						<tr>
    							<th>	#	</th>
    							<th>	Product Name	</th>
    							<th>	Count	</th>    							
    						</tr>
    					</thead>
    					<tbody>
    						<tr>
    							<th>	1	</th>
    							<th>	Cardigan	</th>
    							<th>	43	</th>
    						</tr>
    						<tr>
    							<th>	2	</th>
    							<th>	Slim Fit Pants	</th>
    							<th>	38	</th>
    						</tr>
    						<tr>
    							<th>	3	</th>
    							<th>	Slim Cotton Pants	</th>
    							<th>	31	</th>    							
    						</tr>
    						<tr>
    							<th>	4	</th>
    							<th>	V Neck T-Shirts	</th>
    							<th>	22	</th>    							
    						</tr>
    						<tr>
    							<th>	5	</th>
    							<th>	Round Neck T-Shirts	</th>
    							<th>	19	</th>    							
    						</tr>
    					</tbody>
    				</table>
    			</div>
    		</div>
  		</div>
	</div>
	
""")))};def /*88.2*/chart/*88.7*/(containerID :String):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*88.32*/("""
<script>
	$(function () """),format.raw("""{"""),format.raw/*90.17*/("""
	    var chart;
	    $(document).ready(function() """),format.raw("""{"""),format.raw/*92.36*/("""
	        chart = new Highcharts.Chart("""),format.raw("""{"""),format.raw/*93.40*/("""
	            chart: """),format.raw("""{"""),format.raw/*94.22*/("""
	                renderTo: '"""),_display_(Seq[Any](/*95.30*/containerID)),format.raw/*95.41*/("""',
	                plotBackgroundColor: null,
	                plotBorderWidth: null,
	                plotShadow: true
	            """),format.raw("""}"""),format.raw/*99.15*/(""",
	            title: """),format.raw("""{"""),format.raw/*100.22*/("""
	                text: ''
	            """),format.raw("""}"""),format.raw/*102.15*/(""",
	            tooltip: """),format.raw("""{"""),format.raw/*103.24*/("""
	        	    pointFormat: '"""),format.raw("""{"""),format.raw/*104.30*/("""series.name"""),format.raw("""}"""),format.raw/*104.42*/(""": <b>"""),format.raw("""{"""),format.raw/*104.48*/("""point.percentage"""),format.raw("""}"""),format.raw/*104.65*/("""%</b>',
	            	percentageDecimals: 1
	            """),format.raw("""}"""),format.raw/*106.15*/(""",
	            plotOptions: """),format.raw("""{"""),format.raw/*107.28*/("""
	                pie: """),format.raw("""{"""),format.raw/*108.24*/("""
	                    allowPointSelect: true,
	                    cursor: 'pointer',
	                    dataLabels: """),format.raw("""{"""),format.raw/*111.35*/("""
	                        enabled: true,
	                        color: '#000000',
	                        connectorColor: '#000000',
	                        formatter: function() """),format.raw("""{"""),format.raw/*115.49*/("""
	                            return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
	                        """),format.raw("""}"""),format.raw/*117.27*/("""
	                    """),format.raw("""}"""),format.raw/*118.23*/("""
	                """),format.raw("""}"""),format.raw/*119.19*/("""
	            """),format.raw("""}"""),format.raw/*120.15*/(""",
	            series: ["""),format.raw("""{"""),format.raw/*121.24*/("""
	                type: 'pie',
	                name: 'Browser share',
	                data: [
	                    ['Firefox',   45.0],
	                    ['IE',       26.8],
	                    """),format.raw("""{"""),format.raw/*127.23*/("""
	                        name: 'Chrome',
	                        y: 12.8,
	                        sliced: true,
	                        selected: true
	                    """),format.raw("""}"""),format.raw/*132.23*/(""",
	                    ['Safari',    8.5],
	                    ['Opera',     6.2],
	                    ['Others',   0.7]
	                ]
	            """),format.raw("""}"""),format.raw/*137.15*/("""]
	        """),format.raw("""}"""),format.raw/*138.11*/(""");
	    """),format.raw("""}"""),format.raw/*139.7*/(""");
	    
	"""),format.raw("""}"""),format.raw/*141.3*/(""");
</script>
""")))};
Seq[Any](format.raw/*1.35*/("""

"""),_display_(Seq[Any](/*3.2*/main(title)(username)/*3.23*/ {_display_(Seq[Any](format.raw/*3.25*/("""
	<div id="shotChart">
		<h2> Most shootings </h2>
		<div class="like-well">
			<div class="span8">			
				<div id="shotPie">					
					"""),_display_(Seq[Any](/*9.7*/chart("shotPie"))),format.raw/*9.23*/("""					
				</div>
			</div>
			<div class="span4 table-padding">
			 		"""),_display_(Seq[Any](/*13.8*/table("가장 많이 찍힌 모델 TABLE", "mostShot"))),format.raw/*13.46*/(""" 
			</div>
		</div>								
	</div>
	<div id="likeChart">
		<h2> Most Liked	</h2>
		<div class="like-well">
			<div class="span8">
				<div id="likePie">
					"""),_display_(Seq[Any](/*22.7*/chart("likePie"))),format.raw/*22.23*/("""
				</div>
			</div>
			<div class="span4 table-padding">
				"""),_display_(Seq[Any](/*26.6*/table("가장 좋아한 모델 TABLE", "mostLike"))),format.raw/*26.42*/("""
			</div>		
		</div>
	</div>
	
""")))})),format.raw/*31.2*/("""

"""),format.raw/*85.2*/("""


"""))}
    }
    
    def render(title:String,username:String) = apply(title)(username)
    
    def f:((String) => (String) => play.api.templates.Html) = (title) => (username) => apply(title)(username)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 04 17:16:22 KST 2012
                    SOURCE: /Users/jinsu0411/Documents/soma2/app/views/index.scala.html
                    HASH: ba4c4e250509a0b657b5131b9f4c207ed104a360
                    MATRIX: 762->1|856->635|869->640|964->671|1178->849|1202->851|1252->865|1279->870|1412->967|1436->969|2450->1964|2463->1969|2552->1994|2625->2020|2724->2072|2811->2112|2880->2134|2946->2164|2979->2175|3161->2310|3232->2333|3321->2374|3394->2399|3472->2429|3532->2441|3586->2447|3651->2464|3757->2522|3834->2551|3906->2575|4074->2695|4306->2879|4474->2999|4545->3022|4612->3041|4675->3056|4748->3081|4997->3282|5222->3459|5426->3615|5486->3627|5542->3636|5600->3647|5653->34|5690->37|5719->58|5758->60|5929->197|5966->213|6072->284|6132->322|6328->483|6366->499|6465->563|6523->599|6587->632|6616->1960
                    LINES: 27->1|29->33|29->33|31->33|35->37|35->37|36->38|36->38|40->42|40->42|83->88|83->88|85->88|87->90|89->92|90->93|91->94|92->95|92->95|96->99|97->100|99->102|100->103|101->104|101->104|101->104|101->104|103->106|104->107|105->108|108->111|112->115|114->117|115->118|116->119|117->120|118->121|124->127|129->132|134->137|135->138|136->139|138->141|141->1|143->3|143->3|143->3|149->9|149->9|153->13|153->13|162->22|162->22|166->26|166->26|171->31|173->85
                    -- GENERATED --
                */
            