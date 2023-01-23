<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="jumbotron jumbotron-billboard">
  <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
              <h2>${head}</h2>
              <p>${rental.rentedCar.brand} ${rental.rentedCar.model} - ${rental.rentedCar.category} (${rental.rentedCar.year})</p>
            </div>
        </div>
    </div>
</div>
<section class="container">
	<div class="row">
		
		<div class="card">
			<img class="card-img-top card-image" src="<c:url value="/static/images/prenotazione_img.png" />" alt="Card image cap" style="max-width: 50%;">
 		 	<ul class="list-group list-group-flush">
 		 		<li class="list-group-item">Id: <span class="info-art">${rental.id}</span></li>
 		 		<li class="list-group-item">Data Inizio: <span class="info-art">${rental.startDate}</span></li>
 		 		<li class="list-group-item">Data fine: <span class="info-art">${rental.endDate}</span></li>
 		 		<li class="list-group-item">Prenotato da: <span class="info-art">${rental.referredCustomer.username}</span></li>
 		 		<li class="list-group-item">Targa Auto: <span class="info-art">${rental.rentedCar.licensePlate}</span></li>
  			</ul>
		</div>
	</div>
</section>