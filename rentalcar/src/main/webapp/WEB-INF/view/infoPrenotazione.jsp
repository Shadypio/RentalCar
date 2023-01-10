<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="jumbotron jumbotron-billboard">
  <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
              <h2>${Titolo}</h2>
            </div>
        </div>
    </div>
</div>
<section class="container">
	<div class="row">
		
		<div class="card">
			<img class="card-img-top card-image" src="<c:url value="/static/images/car_bg.jpg" />" alt="Card image cap">
 		 	<ul class="list-group list-group-flush">
 		 		<li class="list-group-item">Id: <span class="info-art">${prenotazione.id}</span></li>
 		 		<li class="list-group-item">Data Inizio: <span class="info-art">${prenotazione.dataInizio}</span></li>
 		 		<li class="list-group-item">Data fine: <span class="info-art">${prenotazione.dataFine}</span></li>
 		 		<li class="list-group-item">Utente: <span class="info-art">${prenotazione.fk_idUtente.username}</span></li>
 		 		<li class="list-group-item">Auto: <span class="info-art">${prenotazione.fk_targaAuto.targa}</span></li>
  			</ul>
		</div>
	</div>
</section>