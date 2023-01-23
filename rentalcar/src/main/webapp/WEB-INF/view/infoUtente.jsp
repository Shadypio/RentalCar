<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="jumbotron jumbotron-billboard">
	<div class="img"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2>${Titolo}</h2>
				<p>${Titolo2}</p>
			</div>
		</div>
	</div>
</div>
<section class="container">
	<div class="row">

		<div class="card">
			<img class="card-img-top card-image"
				src="<c:url value="/static/images/offline_user.png" />"
				alt="Card image cap">
			<ul class="list-group list-group-flush">
				<li class="list-group-item">Nome: <span class="info-art">${utente.nome}</span></li>
				<li class="list-group-item">Cognome: <span class="info-art">${utente.cognome}</span></li>
				<li class="list-group-item">Username: <span class="info-art">${utente.username}</span></li>
				<li class="list-group-item">Data di nascita: <span
					class="info-art">${utente.dataDiNascita}</span></li>
				<li class="list-group-item">Ruolo: <span class="info-art">${utente.ruolo.nomeRuolo}</span></li>
			</ul>
		</div>

		
		<ul class="list-group list-group-flush">
		<c:if test="${noRentals != null}">
			<div class="alert alert-danger">
				<p>
					${noRentals}
				</p>
			</div>
		</c:if>
			<li class="list-group-item"><a
				href="<spring:url value="/prenotazione/getfromutente/${utente.idUtente}" /> "
				class="btn btn-warning table-buttons"> <span
					class="oi oi-list-rich"></span> Prenotazioni effettuate
			</a></li>
			<li class="list-group-item"><a
				href="<spring:url value="/utente/modifica/${utente.idUtente}" /> "
				class="btn btn-warning table-buttons"> <span
					class="oi oi-pencil"></span> Modifica profilo
			</a></li>
			<c:if test="${utente.ruolo.idRuolo == 1}">
				<li class="list-group-item"><a
					href="<spring:url value="/utente/" /> "
					class="btn btn-warning table-buttons"> <span
						class="oi oi-people"></span> Gestione utenti
				</a></li>
				
				<li class="list-group-item"><a
					href="<spring:url value="/prenotazione/" /> "
					class="btn btn-warning table-buttons"> <span
						class="oi oi-pencil"></span> Gestione Prenotazioni
				</a></li>

			
		</c:if>
		</ul>

	</div>
</section>