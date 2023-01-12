<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 

<!doctype html>
<html lang="it">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="<c:url value="/static/css/bootstrap.min.css" />" rel="stylesheet">
    
    <!-- open-iconic -->
    <link href="<c:url value="/static/css/open-iconic-bootstrap.css" />" rel="stylesheet">
    
    <!-- Altri CSS -->
    <link href="<c:url value="/static/css/main.css" />" rel="stylesheet">

    <title><tiles:insertAttribute name="titolo" /></title>
  </head>
  <body>
  <!-- Navigation Bar --> 
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
    	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
  		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
  		
  			 <a class="navbar-brand" href="<spring:url value="/"/>">RentalCar</a>
  			 <a class="nav-link" href="<spring:url value="/auto"/>">
        					<span class="oi oi-box" title="box" aria-hidden="true"></span>
        					Parco Auto
        					<span class="sr-only">(current)</span>
        				</a>
        	<a class="nav-link" href="<spring:url value="/utente/"/>">
        					<span class="oi oi-bullhorn" title="bullhorn" aria-hidden="true"></span>
        					Profilo Utente
        					<span class="sr-only">(current)</span>
        				</a>		
  		</div>
    </nav> 
    
     <tiles:insertAttribute name="content" /> 
     
     <tiles:insertAttribute name="footer" />  
      
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script type="text/javascript" src="<c:url value="/static/js/jquery-3.2.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/static/js/bootstrap.min.js" />"></script>
     <script type="text/javascript" src="<c:url value="/static/js/main.js" />"></script>
  </body>
</html>