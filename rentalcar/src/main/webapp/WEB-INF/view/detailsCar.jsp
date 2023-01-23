<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 

<div class="jumbotron jumbotron-billboard">
  <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
              <h2>${head}</h2>
                <p>${subheading}</p>
            </div>
        </div>
    </div>
</div>
<section class="container">
	<div class="row">
		
		<div class="card">
			<img class="card-img-top card-image" src="<c:url value="/static/images/car_bg.jpg" />" alt="Card image cap">
 		 	<ul class="list-group list-group-flush">
 		 		<li class="list-group-item">Marca: <span class="info-art">${car.brand}</span></li>
 		 		<li class="list-group-item">Modello: <span class="info-art">${car.model}</span></li>
 		 		<li class="list-group-item">Categoria: <span class="info-art">${car.category}</span></li>
 		 		<li class="list-group-item">Anno di Immatricolazione: <span class="info-art">${car.year}</span></li>
  			</ul>
  			<div class="card-body">
  			
  			<a href="<spring:url value="/rental/add/${car.licensePlate}" /> " class="card-link">Prenota</a>
    		<a href="javascript:history.back()" class="card-link">Annulla</a>
  			</div>
		</div>
	</div>
</section>