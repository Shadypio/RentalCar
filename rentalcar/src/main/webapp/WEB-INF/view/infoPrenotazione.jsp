<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="jumbotron jumbotron-billboard">
  <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
              <h2>${Titolo}</h2>
              <p>${prenotazione.auto.marca} ${prenotazione.auto.modello} - ${prenotazione.auto.categoria} (${prenotazione.auto.anno})</p>
            </div>
        </div>
    </div>
</div>
<section class="container">
	<div class="row">
		
		<div class="card">
			<img class="card-img-top card-image" src="<c:url value="/static/images/prenotazione_img.png" />" alt="Card image cap" style="max-width: 50%;">
 		 	<ul class="list-group list-group-flush">
 		 		<li class="list-group-item">Id: <span class="info-art">${prenotazione.idPrenotazione}</span></li>
 		 		<li class="list-group-item">Data Inizio: <span class="info-art">${prenotazione.dataInizio}</span></li>
 		 		<li class="list-group-item">Data fine: <span class="info-art">${prenotazione.dataFine}</span></li>
 		 		<li class="list-group-item">Prenotato da: <span class="info-art">${prenotazione.utente.username}</span></li>
 		 		<li class="list-group-item">Targa Auto: <span class="info-art">${prenotazione.auto.targa}</span></li>
  			</ul>
		</div>
	</div>
</section>